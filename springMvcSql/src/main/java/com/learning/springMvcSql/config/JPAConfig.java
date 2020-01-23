package com.learning.springMvcSql.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.learning.springMvcSql.entity"})
@EnableTransactionManagement
/*
 * @PropertySource({ "classpath:database.properties" })
 */
/*
 * @ComponentScan({ "com.learning.springMvcSql" })
 */
public class JPAConfig {
	
	/*
	 * @Autowired private Environment env;
	 */	 
	 

	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setPackagesToScan(new String[] {
	            "com.learning.springMvcSql.entity"
	        });

	        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	        entityManagerFactoryBean.setJpaProperties(additionalProperties());

	        return entityManagerFactoryBean;
	    }

	    final Properties additionalProperties() {
	        final Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
	        hibernateProperties.setProperty("hibernate.cache.use_query_cache", "false");
	        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
	        return hibernateProperties;
	    }

	    @Bean
	    public DataSource dataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/springMvcDb");
	        dataSource.setUsername("springMvcUser");
	        dataSource.setPassword("springMvcPassword");
	        return dataSource;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	        final JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }

	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }
}
