package com.learning.spring5.springRestMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//this is similiar to bean config file that maps to dispatcher servler in web.xml

//@config means we can define beans here and this will load the spring context
@Configuration
@EnableWebMvc
@ComponentScan("com.learning.spring5.springRestMVC")
public class SpringDemoConfig {

}
