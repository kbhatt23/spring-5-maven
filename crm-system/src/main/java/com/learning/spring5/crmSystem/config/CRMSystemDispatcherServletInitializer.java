package com.learning.spring5.crmSystem.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CRMSystemDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {CRMSystemConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}


}
