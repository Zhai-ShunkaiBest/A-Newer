package com.cliffside.listener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-29 21:26
 */
@WebServlet(urlPatterns = "/myServlet.action")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "zhangsan");
        req.setAttribute("name", "lisi");
        req.removeAttribute("name");
    }
}