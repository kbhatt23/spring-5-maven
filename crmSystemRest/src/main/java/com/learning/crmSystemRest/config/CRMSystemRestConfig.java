package com.learning.crmSystemRest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.learning.crmSystemRest")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class CRMSystemRestConfig {

}
