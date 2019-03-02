package com.yuan.springcloud.scsrv.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class DistributedLock implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(DistributedLock.class);

    @Autowired
    private JedisUtil jedisUtil;


    public Boolean tryLock(String key, String value, Date expiry) {
        return tryLock(key, value, 0L, null, expiry);
    }

    public Boolean tryLock(String key, String value, long timeout, TimeUnit unit, Date expiry) {

        unit = (null == unit)? TimeUnit.SECONDS:unit;
        int expireTime = (int) ((expiry.getTime() - System.currentTimeMillis()) / 1000);
        try {
            long begin = System.nanoTime();
            do {
                String result = jedisUtil.getRedisSource().set(key, value, "NX", "PX", expireTime);
                if (StringUtils.equalsIgnoreCase("OK", result)) {
                    logger.info("{} success get{} lock,set lock timeout {} second ", value, key, expireTime);
                    return Boolean.TRUE;
                }
                if (timeout == 0) {
                    break;
                }
                Thread.sleep(100);
            } while ((System.nanoTime() - begin) < unit.toNanos(timeout));
            return Boolean.FALSE;
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return Boolean.FALSE;
        }
    }

    public Boolean releaseLock(String key) {
        try {
            jedisUtil.getRedisSource().del(key);
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void afterPropertiesSet() throws Exception {

        logger.info("DistributedLock init");
    }

}
