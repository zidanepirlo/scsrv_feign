package com.yuan.springcloud.scsrv.service.impl;

import com.yuan.springcloud.scsrv.common.utils.JedisUtil;
import com.yuan.springcloud.scsrv.service.ICacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CacheServiceImpl implements ICacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public Boolean add(String key, String value) {

        Boolean addResult = Boolean.TRUE;
        try {
            long result = jedisUtil.getRedisSource().setnx(key, value);
            if (result != 1) {
                addResult = Boolean.FALSE;
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            addResult = Boolean.FALSE;
        }
        return addResult;
    }

    @Override
    public Boolean add(String key, String value, Date expiry) {
        Boolean addResult = Boolean.TRUE;
        try {
            long result = jedisUtil.getRedisSource().setnx(key, value);
            if (result == 1) {
                jedisUtil.getRedisSource().expire(key, (int) ((expiry.getTime() - System.currentTimeMillis()) / 1000));
            } else {
                addResult = Boolean.FALSE;
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            addResult = Boolean.FALSE;
        }
        return addResult;
    }

    @Override
    public Boolean set(String key, String value, Date expiry) {
        try {
            jedisUtil.getRedisSource().setex(key, (int) ((expiry.getTime() - System.currentTimeMillis()) / 1000), value);
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public String get(String key) {

        String value = null;
        try{
            value = jedisUtil.getRedisSource().get(key);
        }catch (Throwable e){
            logger.error(e.getMessage(),e);
        }

        return value;
    }
}
