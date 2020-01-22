package com.learning.spring5.springRestMVC.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//this class is similar to web.xml

public class SpringBasicRestDispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	//giving sporing context config mapping for dispatcher servler in web.xml
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringDemoConfig.class};
	}

	//this is similiar to servler mapping of all urls to go to dispatcher servlet
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
