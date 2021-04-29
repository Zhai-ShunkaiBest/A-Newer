package com.cliffside.springboot_scaffold.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-29 15:08
 */
@WebServlet(name = "myServlet",urlPatterns = "/servlet1.action")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("exec doGet");
        super.doGet(req, resp);
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("exec doGet");
//        super.service(req, resp);
//    }
}
