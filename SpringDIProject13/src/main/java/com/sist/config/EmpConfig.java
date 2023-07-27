package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/*
   @Component, 
   @Repository, 
   @Service, 
   @Controller, 
   @RestController, 
   @ControllerAdvice, 
   @Configuration 
 */
@Configuration
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = "com.sist.*")
// <mybatis-spring:scan base-package="com.sist.mapper2"/>
@MapperScan(basePackages = "com.sist.mapper2")
public class EmpConfig {
	/*
	   <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="#{db['driver']}"
		p:url="#{db['url']}"
		p:username="#{db['username']}"
		p:password="#{db['password']}"
		/>
	 */
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@211.238.142.122:1521:xe");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		/>
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
}
