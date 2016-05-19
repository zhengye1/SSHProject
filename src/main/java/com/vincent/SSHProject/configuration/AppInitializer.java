package com.vincent.SSHProject.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	static Logger logger = LoggerFactory.getLogger(AppInitializer.class); 
    @Override
    protected Class<?>[] getRootConfigClasses() {
    	logger.info("AppInit - getRootConfig");
        return new Class[] { AppConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	logger.info("AppInit - getServletConfig");
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
    	logger.info("AppInit - getServletMapping");
        return new String[] { "/" };
    }
}
