package com.cliffside.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-29 21:56
 * 1当任何一个账户处于登录状态时,在线统计总数+1,离线时-1
 *
 * 2通过session监听器实现计数,但是在线人数要保存在Application域中
 *
 *
 */
@WebListener
public class OnlineDemo implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 向application域中 增加一个数字
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        Object attribute = application.getAttribute("count");
        if(null == attribute){// 第一次放数据
            application.setAttribute("count", 1);
        }else{
            int count =(int)attribute;
            application.setAttribute("count", ++count);
        }
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 向application域中 减少一个数字
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        int count =(int)application.getAttribute("count");
        application.setAttribute("count", --count);
    }
}
@WebServlet(urlPatterns = "/logout.action")
class Logout extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.invalidate();
    }
}