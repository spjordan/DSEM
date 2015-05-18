package com.up10.DSEM.init;

import javax.servlet.*;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {
	 
	  // gets invoked automatically when application starts up
	  public void onStartup(ServletContext servletContext) throws ServletException {
	 
	    // Create ApplicationContext. I'm using the
	    // AnnotationConfigWebApplicationContext to avoid using beans xml files.
	    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	    ctx.register(Webappconfig.class);
	 
	    // Add the servlet mapping manually and make it initialize automatically
	    Dynamic servlet =
	        servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
	    servlet.addMapping("/");
	    servlet.setLoadOnStartup(1);
	  }
	 
}
