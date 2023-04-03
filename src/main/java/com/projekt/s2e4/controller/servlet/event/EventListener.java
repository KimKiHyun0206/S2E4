package com.projekt.s2e4.controller.servlet.event;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class EventListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("[System] Event Context Initialized");
        sce.getServletContext().setAttribute("event", "event");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("[System] Event Context Destroyed");
    }
}