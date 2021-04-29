package com.cliffside;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-28 20:54
 */
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+ "     "+password);
        // 如果用户名和密码为 msb 1234
        if("admin".equals(username)  && "1234".equals(password)){
            // 将用户信息放在HTTPSession中
            User user =new User(null, null, "admin", "admin");
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            // 登录成功 跳转至 main.html
            resp.sendRedirect(req.getContextPath()+"/mainServlet");
        }else{
            // 登录失败 回到login.html
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }

    }
}
