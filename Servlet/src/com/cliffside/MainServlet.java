package com.cliffside;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpClient;

/**
 * @author cliffside
 * @date 2021-04-28 22:41
 */
@WebServlet(urlPatterns = "/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转至main.html
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(null != user){
            // 判断如果登录过 允许跳转  HTTPSession中如果有登陆过的信息
            req.getRequestDispatcher("/WEB-INF/main.html").forward(req,resp);
        }else{
            // 如果没有登录过 回到登录去登录  HTTPSession中如果有登陆过的信息
            resp.sendRedirect("login.html");
        }
    }
}
