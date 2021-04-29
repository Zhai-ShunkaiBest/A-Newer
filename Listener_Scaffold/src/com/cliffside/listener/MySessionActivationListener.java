package com.cliffside.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author cliffside
 * @date 2021-04-29 21:44
 */
@WebListener
public class MySessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session即将钝化");
    }
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session活化完毕");
    }
}