package com.cliffside.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author cliffside
 * @date 2021-04-29 21:43
 */
@WebListener
public class MySessionBindingListener implements HttpSessionBindingListener {
    // 绑定方法
    /*
    session.setAttribute("mySessionBindingListener",new MySessionBindingListener())
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("监听器和某个session对象绑定了");
    }
    // 解除绑定方法
    /*
     * 当发生如下情况,会触发该方法的运行
     * 1 session.invalidate(); 让session不可用
     * 2 session到达最大不活动时间,session对象回收 ;
     * 3 session.removeAttribute("mySessionBindingListener");手动解除绑定
     * */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
    }
}