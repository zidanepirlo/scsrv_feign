package com.yuan.springcloud.scsrv.common.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * SqlSessionFactoryConfig
 *
 * @author yuanqing
 * @create 2019-04-02 21:50
 **/

@Configuration
public class SqlSessionFactoryConfig {

    /**   mybatis 配置路径     */
    private static String MYBATIS_CONFIG = "mybatis.xml";
    /**   mybatis mapper resource 路径     */
    private static String MAPPER_PATH = "/mapping/*-Mapper.xml";

    private static String typeAliasPackage = "com.yuan.springcloud.scsrv";

    @Autowired
    private DataSource dataSource;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactory() throws IOException {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath:/mapping/*-Mapper.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactoryBean;
    }


}
