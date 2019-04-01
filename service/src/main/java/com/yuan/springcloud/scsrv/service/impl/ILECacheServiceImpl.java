package com.yuan.springcloud.scsrv.service.impl;

import com.yuan.springcloud.scsrv.common.utils.LettuceUtil;
import com.yuan.springcloud.scsrv.service.ILECacheService;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ILECacheServiceImpl
 *
 * @author yuanqing
 * @create 2019-03-07 14:26
 **/

@Service
public class ILECacheServiceImpl implements ILECacheService {

    private static final Logger logger = LoggerFactory.getLogger(ILECacheServiceImpl.class);

    @Autowired
    private LettuceUtil lettuceUtil;

    @Override
    public Boolean add(String key, String value) {

        Boolean addResult = Boolean.FALSE;
        RedisClusterClient client = RedisClusterClient.create(lettuceUtil.getRedisUriList());
        StatefulRedisClusterConnection<String, String> connect = client.connect();
        try {

            RedisAdvancedClusterCommands<String, String> commands = connect.sync();
            addResult = commands.setnx(key,value);
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            addResult = Boolean.FALSE;
        } finally {
            connect.close();
            client.shutdown();
        }
        return addResult;
    }

    @Override
    public Boolean add(String key, String value, Date expiry) {

        Boolean addResult = Boolean.TRUE;
        RedisClusterClient client = RedisClusterClient.create(lettuceUtil.getRedisUriList());
        StatefulRedisClusterConnection<String, String> connect = client.connect();

        try {

            RedisAdvancedClusterCommands<String, String> commands = connect.sync();
            addResult = commands.setnx(key, value);
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            addResult = Boolean.FALSE;
        }finally {
            connect.close();
            client.shutdown();
        }
        return addResult;
    }

    @Override
    public Boolean set(String key, String value, Date expiry) {

        RedisClusterClient client = RedisClusterClient.create(lettuceUtil.getRedisUriList());
        StatefulRedisClusterConnection<String, String> connect = client.connect();

        try {
            RedisAdvancedClusterCommands<String, String> commands = connect.sync();
            commands.setex(key,(int) ((expiry.getTime() - System.currentTimeMillis()) / 1000),value);
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            return Boolean.FALSE;
        }
        finally {
            connect.close();
            client.shutdown();
        }
        return Boolean.TRUE;
    }

    @Override
    public String get(String key) {

        String value = null;
        RedisClusterClient client = RedisClusterClient.create(lettuceUtil.getRedisUriList());
        StatefulRedisClusterConnection<String, String> connect = client.connect();
        try{

            RedisAdvancedClusterCommands<String, String> commands = connect.sync();
            value = commands.get(key);
        }catch (Throwable e){
            logger.error(e.getMessage(),e);
        }finally {
            connect.close();
            client.shutdown();
        }

        return value;
    }
}
