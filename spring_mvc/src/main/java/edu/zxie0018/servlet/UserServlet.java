package edu.zxie0018.servlet;

import edu.zxie0018.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        // ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");

        // 1. this spring applicationContext from my package
        // get attribute from servletContext object and convert to object spring ApplicationContext
        // ApplicationContext app = edu.zxie0018.listener.WebApplicationContextUtils.WebApplicationContextUtils.getApplicationContext(servletContext);

        // 2. this spring applicationContext from springframework  **SPRING-MVC**
        // org.springframework.web.context.support.WebApplicationContextUtils
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
