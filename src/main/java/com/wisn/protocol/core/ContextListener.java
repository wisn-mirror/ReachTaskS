package com.wisn.protocol.core;

import com.wisn.tool.PropertiesOperation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

public class ContextListener implements ServletContextListener {

    private Timer timer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String file = servletContextEvent.getServletContext().getRealPath("/WEB-INF/classes/netty.properties");
        PropertiesOperation propertiesOperation = new PropertiesOperation(file);
        Properties properties = propertiesOperation.getProperties();
        if (properties != null) {
            propertiesOperation.printProperties();
            String host = properties.getProperty("host");
            int port = Integer.parseInt(properties.getProperty("port"));
            boolean enable = Boolean.valueOf(properties.getProperty("enable"));
            if (enable) {
                MessageServer.start(host, port);
            }
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, new Date(), 2000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (timer != null) {
            timer.cancel();
        }
    }
}
