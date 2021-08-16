package com.ray.citymanager.sessionlisteners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class SessionTrackingAndLogging implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public SessionTrackingAndLogging() {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.printf("Attribute Added to session: %s\t%s\n", sbe.getName(), sbe.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.printf("Attribute Removed from session: %s\t%s\n", sbe.getName(), sbe.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.printf("Attribute replaced in session: %s\t%s\n", sbe.getName(), sbe.getValue());
    }
}
