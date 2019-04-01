package com.yuan.springcloud.scsrv.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
@EnableTransactionManagement
//org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class disable web security
//@SpringBootApplication(exclude =
//		{DataSourceAutoConfiguration.class,
//				org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class},scanBasePackages = "com.yuan.springcloud")
@SpringBootApplication(exclude =
		{org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class},scanBasePackages = "com.yuan.springcloud")
@MapperScan(basePackages = "com.yuan.springcloud.scsrv.dao.domain.**",sqlSessionFactoryRef = "sqlSessionFactory" )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
