package com.learning.spring_mvc_security_jdbc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//this class is replacement of web.xml
//for this we have added javax serlvet maven dependency
public class SpringSecurityDispathcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringSecurityConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//add dispatcher servlet to all urll patterns
		return new String[] {"/"};
	}

}
