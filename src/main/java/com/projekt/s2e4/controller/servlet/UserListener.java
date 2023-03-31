package com.projekt.s2e4.controller.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

@Slf4j
@WebServlet
public class UserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("User Context Initialized");
        sce.getServletContext().setAttribute("user", "user");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("User Context Destroyed");
    }
}
