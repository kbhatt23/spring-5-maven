package com.learning.spring_mvc_security_jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class SpringSecurityMVCConfig {

	 
	   @Bean
	   public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      //by default webapp is there, create foler view there
	      resolver.setPrefix("/view/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	 
	//   @Bean
	  // public MessageSource messageSource() {
	    //  ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      //source.setBasename("messages");
	      //return source;
	   //}
	 
}
