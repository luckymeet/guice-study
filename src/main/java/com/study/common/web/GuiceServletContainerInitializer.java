package com.study.common.web;

import com.study.common.config.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class GuiceServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        ServletRegistration.Dynamic servletContainer = ctx.addServlet("servletContainer", new ServletContainer(new JerseyConfig()));
        servletContainer.addMapping("/*");
    }
}
