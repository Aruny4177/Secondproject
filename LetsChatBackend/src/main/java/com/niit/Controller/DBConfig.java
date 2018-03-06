package com.niit.Controller;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.sun.xml.internal.fastinfoset.sax.Properties;


@Configuration
@EnableTransactionManagement

@ComponentScan("com.niit")

public class DBConfig {

	//1.Data Source Object
	
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUsername("SYSTEM");
		dataSource.setPassword("oracle");

		return dataSource;
	}
	
	
	//2.Create sessionFactory Bean
	@Bean(name="sessionFactory")
	public SessionFactoryUtils getSessionFactroy()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbmddl2.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.addProperties(hibernateProp);
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		System.out.println("------SessionFactory Object----------");
		return sessionFactory;
		
	}
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO()
	{
		return new BlogDAOImpl();
	}
	
	@Bean
	 public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	       
	       
	       return new HibernateTransactionManager(sessionFactory);
	    } 
}
