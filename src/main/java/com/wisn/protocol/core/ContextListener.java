package com.wisn.protocol.core;

import com.wisn.dao.UserDao;
import com.wisn.entity.User;
import com.wisn.service.impl.UserServiceImpl;
import com.wisn.tools.PropertiesOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;
@Component
public class ContextListener implements ServletContextListener {

    private Timer timer;

    private UserDao userDao;
    private UserServiceImpl userServiceImpl;

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
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        if(webApplicationContext != null){
            userDao = (UserDao) webApplicationContext.getBean("UserDao");
            List<User> users = userDao.queryAllToken();
            for(User user:users){
                System.out.println(user.toString());
            }
        }else {
            System.out.println("33333");
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                System.out.println(" userDao"+userDao);
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
