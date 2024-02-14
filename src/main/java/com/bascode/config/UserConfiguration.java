package com.bascode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

@Configuration
@Data
//@PropertySource("classpath:jdbc.properties")
public class UserConfiguration {
	/*
	 * @Value("${jdbc.className}") private String jdbcClasName;
	 * 
	 * @Value("${jdbc.url}") private String jdbcUrl;
	 * 
	 * @Value("${jdbc.name}") private String jdbcUserName;
	 * 
	 * @Value("${jdbc.password}") private String jdbcPassword;
	 */
	
	
	@Bean
	JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
	   return new JdbcTemplate(hikariDataSource);
	  
		
	}

}
