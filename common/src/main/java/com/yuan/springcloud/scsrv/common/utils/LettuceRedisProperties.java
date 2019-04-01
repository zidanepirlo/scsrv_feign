package com.yuan.springcloud.scsrv.common.utils;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConfigurationProperties(prefix = "lettuce.redis")
@Setter
@Getter
public class LettuceRedisProperties {

    private static final Logger logger = LoggerFactory.getLogger(LettuceRedisProperties.class);

    private String clusterNodes;
    private String maxRedirects;
    private String autoReconnect;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {

        logger.info("lettuce redis cluster init begin");
        logger.info("clusterNodes : "+clusterNodes);
        logger.info("maxRedirects : "+maxRedirects);
        logger.info("autoReconnect : "+autoReconnect);
    }
}
