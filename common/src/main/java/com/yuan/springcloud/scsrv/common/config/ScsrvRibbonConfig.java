package com.yuan.springcloud.scsrv.common.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ScsrvRibbonConfig
 *
 * @author yuanqing
 * @create 2019-06-02 18:12
 **/
@Configuration
public class ScsrvRibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
