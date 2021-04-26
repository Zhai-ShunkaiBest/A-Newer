package com.cliffside;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-26 13:51
 */
public class servlet extends HttpServlet {
    /**
     * 接收浏览器请求，并作出运算和响应
     * 如果我们想获得请求中的信息,就要通过HttpServetRequest对象获得
     * 如果我们想给浏览器响应一些信息,就要通过HttpServletResponse对象响应
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
