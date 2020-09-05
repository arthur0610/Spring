package edu.zxie0018.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();
        // read contextConfigLocation from web.xml
        // get the value from context-param key-value pair from web.xml
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        // create Spring ApplicationContext object
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        // store object into servletContext as an attribute
        servletContext.setAttribute("app", app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
