package com.yuan.springcloud.scsrv.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
//@EnableEurekaClient
@EnableCircuitBreaker
@EnableTransactionManagement
@EnableFeignClients
@ComponentScan(basePackages={"com.yuan.springcloud.scsrv"})
@SpringBootApplication(exclude =
		{
				org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                DataSourceAutoConfiguration.class
				,
				EurekaClientAutoConfiguration.class

		},scanBasePackages = "com.yuan.springcloud")
@MapperScan(basePackages = "com.yuan.springcloud.scsrv.dao.domain.**",sqlSessionFactoryRef = "sqlSessionFactory" )
//@MapperScan(basePackages = "com.yuan.springcloud.scsrv.dao.domain.**" )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
