/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.yuan.springcloud.scsrv.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * The type Druid configuration.
 */
@Configuration
public class DruidConfig {

	/**   mybatis 配置路径     */
	private static String MYBATIS_CONFIG = "mybatis.xml";
	/**   mybatis mapper resource 路径     */
	private static String MAPPER_PATH = "/mapping/*-Mapper.xml";

	private String typeAliasPackage = "com.yuan.springcloud.scsrv";

	/**
	 * Druid data source druid data source.
	 *
	 * @return the druid data source
	 */
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean(name="druidDataSource",destroyMethod = "close", initMethod = "init")
	public DruidDataSource getDruidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}

	/**
	 * Data source data source.
	 *
	 * @param druidDataSource the druid data source
	 * @return the data source
	 */
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	@Bean("dateSourceProxy")
	public DataSource getDateSourceProxy(DruidDataSource druidDataSource) {
		DataSourceProxy dataSourceProxy = new DataSourceProxy(getDruidDataSource());
		return dataSourceProxy;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean getSqlSessionFactory() throws IOException {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		/** 设置mybatis configuration 扫描路径 */
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
		/** 添加mapper 扫描路径 */
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
		/** 设置datasource */
		sqlSessionFactoryBean.setDataSource(getDateSourceProxy(getDruidDataSource()));
		/** 设置typeAlias 包扫描路径 */
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
		return sqlSessionFactoryBean;
	}

	@Bean("transactionManager")
	public DataSourceTransactionManager oracleTransactionManager(@Qualifier("dateSourceProxy")DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
