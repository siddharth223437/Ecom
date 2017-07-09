package com.ecom.spring.configure;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ecom.common.vo.Products;
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.ecom.*")
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Bean(name="viewResolver")
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setSuffix(".jsp");
		viewResolver.setPrefix("/WEB-INF/views/");
		return viewResolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry
		.addResourceHandler("/assets/**")
		.addResourceLocations("/assets/");
		
	}
	
	@Bean(name="dataSource")
	public DataSource getDatasource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:8889/EcomDB");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClass(Products.class);
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties(){
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
