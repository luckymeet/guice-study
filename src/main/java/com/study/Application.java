package com.study;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.study.config.JerseyConfig;
import com.study.module.UserModule;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.Servlet;

public class Application {
    public static void main(String[] args) {
        Server server = new Server(8080);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);

        contextHandler.addServlet(new ServletHolder(new ServletContainer(new JerseyConfig())), "/*");

        server.setHandler(contextHandler);

        Injector injector = Guice.createInjector(new UserModule());

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
