package com.ray.citymanager.sessionlisteners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class ActiveUserTracking implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private static int activeUsers;

    public ActiveUserTracking() { }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("A new session has been created");
        activeUsers++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("An existing session has been closed");
        activeUsers--;
    }

    public static int getActiveUsers() {
        return activeUsers;
    }
}
