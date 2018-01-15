package com.wisn.protocol.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ContextListener implements ServletContextListener {

    private Timer timer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String file = servletContextEvent.getServletContext().getRealPath("/WEB-INF/classes/netty.properties");
//        MessageServer.start();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("thread  "+file);
            }
        }, new Date(), 2000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if(timer!=null){
            timer.cancel();
        }
    }
}
