package com.learning.crmSystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//this replaces bean config xml
@Configuration
@ComponentScan("com.learning.crmSystem")
//so that controler model and view works
//@EnableWebMvc
public class CRMSpringConfig {
	//we can create beans here if we want

}
