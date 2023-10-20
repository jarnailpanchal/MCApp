package com.market.connect.config;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {

	@Autowired
	private Environment environment;

    @Primary
    @Bean(name = "primaryDb")
    DataSource getDatasource() {
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();

		PoolProperties pProperties = new PoolProperties();
		pProperties.setUrl(environment.getProperty("spring.datasource.url"));
		pProperties.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		pProperties.setUsername(environment.getProperty("spring.datasource.username"));
		pProperties.setPassword(environment.getProperty("spring.datasource.password"));
		pProperties.setValidationInterval(30000);
		pProperties.setMinIdle(30);
		pProperties.setMaxActive(50);
		pProperties.setInitialSize(30);
		pProperties.setMaxIdle(50);
		ds.setPoolProperties(pProperties);
		return ds;
	}

}
