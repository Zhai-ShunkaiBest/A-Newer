package example.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * @author cliffside
 * @date 2021-04-29 14:06
 */
@WebListener
public class MyListener implements ServletRequestListener , ServletRequestAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        // 监听HttpServletRequest对象的销毁
        // 项目中任何一个Request对象的销毁都会触发该方法的执行
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("request"+servletRequest.hashCode()+"对象销毁了");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
// 监听HttpServletRequest对象的创建并初始化
// 项目中任何一个Request对象的创建并初始化都会触发该方法的执行
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("request"+servletRequest.hashCode()+"对象初始化");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        // 任何一个Request对象中调用 setAttribute方法增加了数据都会触发该方法
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        System.out.println("request"+servletRequest.hashCode()+"对象增加了数据:"+name+"="+value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
// 任何一个Request对象中调用 removeAttribute方法移除了数据都会触发该方法
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        System.out.println("request"+servletRequest.hashCode()+"对象删除了数据:"+name+"="+value);

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        // 任何一个Request对象中调用 setAttribute方法修改了数据都会触发该方法
        ServletRequest servletRequest = servletRequestAttributeEvent.getServletRequest();
        String name = servletRequestAttributeEvent.getName();
        Object value = servletRequestAttributeEvent.getValue();
        Object newValue=servletRequest.getAttribute(name);
        System.out.println("request"+servletRequest.hashCode()+"对象增修改了数据:"+name+"="+value+"设置为:"+newValue);
    }
}
