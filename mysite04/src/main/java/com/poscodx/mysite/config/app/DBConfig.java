package com.poscodx.mysite.config.app;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://192.168.0.178:3307/webdb?charset=utf8");
		dataSource.setUsername("webdb");
		dataSource.setPassword("webdb");
		// counnection 몇 개?
		dataSource.setInitialSize(10);
		// 동시 접속 개수 (넘으면, 기다리게 함)
		dataSource.setMaxActive(20);
		
		return dataSource;
	}
}
