package com.learning.crmSystem.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Hello world!
 *
 */
//this replaces web.xml
public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//this gets clalled even before our servlet config class
		//no need as of now
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {CRMSpringConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}
