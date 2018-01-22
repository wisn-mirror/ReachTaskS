package com.wisn.protocol.core;

import com.wisn.dao.UserDao;
import com.wisn.entity.User;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.service.impl.UserServiceImpl;
import com.wisn.tools.LogUtils;
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

    private static final String TAG = "ContextListener";
    private Timer timer;

    private UserDao userDao;
    private UserServiceImpl userServiceImpl;
    private WebApplicationContext webApplicationContext;
    private boolean enable;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String file = servletContextEvent.getServletContext().getRealPath("/WEB-INF/classes/netty.properties");
        PropertiesOperation propertiesOperation = new PropertiesOperation(file);
        Properties properties = propertiesOperation.getProperties();
        if (properties != null) {
            propertiesOperation.printProperties();
            String host = properties.getProperty("host");
            int port = Integer.parseInt(properties.getProperty("port"));
            enable = Boolean.valueOf(properties.getProperty("enable"));
            if (enable) {
                MessageServer.start(host, port);
            }
        }
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        if (webApplicationContext != null) {
            userDao = webApplicationContext.getBean(UserDao.class);
            List<User> users = userDao.queryAllToken();
            for (User user : users) {
                LogUtils.d(TAG, "user:"+user.toString() );
                if (user == null || user.getToken() == null || user.getExpired() == 0) continue;
                TokenEntity tokenEntity = new TokenEntity(user.getUserid(), user.getExpired());
                if (!tokenEntity.isExpired()) {
                    LogUtils.d(TAG, user.getUserid() + "add tokenManager");
                    TokenManager.putToken(user.getToken(), tokenEntity);
                } else {
                    LogUtils.d(TAG, user.getUserid() + "is expired");
                }
            }
        } else {
            LogUtils.d(TAG, "webApplicationContext is" + webApplicationContext);
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
