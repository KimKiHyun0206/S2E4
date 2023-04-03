package com.projekt.s2e4.controller.servlet.item;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class ItemListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("[System] Item Context Initialized");
        sce.getServletContext().setAttribute("item", "item");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("[System] Item Context Destroyed");
    }
}
