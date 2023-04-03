package com.projekt.s2e4.controller.servlet.user;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class UserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("[System] User Context Initialized");
        sce.getServletContext().setAttribute("user", "user");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("[System] User Context Destroyed");
    }
}