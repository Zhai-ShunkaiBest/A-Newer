package com.cliffside;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author cliffside
 * @date 2021-04-26 13:51
 */
@WebServlet(urlPatterns = "/servlet.action"
            ,initParams = {
                @WebInitParam(name = "name", value = "admin"),
                @WebInitParam(name = "pwd",value = "admin")
            }
)
public class servlet extends HttpServlet {
    /**
     * 接收浏览器请求，并作出运算和响应
     * 如果我们想获得请求中的信息,就要通过HttpServetRequest对象获得
     * 如果我们想给浏览器响应一些信息,就要通过HttpServletResponse对象响应
     * @param req HttpServletRequest对象代表客户端浏览器的请求，
     *            当客户端浏览器通过HTTP协议访问服务器时，
     *            HTTP请求中的所有信息都会被Tomcat所解析并封装在这个对象中，
     *            通过这个对象提供的方法，可以获得客户端请求的所有信息。
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        Enumeration<String> headers = req.getHeaderNames();
        if (username.equals("admin")&&pwd.equals("admin")){
            PrintWriter writer = resp.getWriter();
            writer.write("yes");
        }else {
            PrintWriter writer = resp.getWriter();
            writer.write("nono");
        }


        //PrintWriter writer = resp.getWriter();
        //writer.write("hello");
    }
}
/**
 * 流程
 * 1创建一个JAVAWEB项目,并在项目中开发一个自己的Servlet ,继承HttpServlet 类
 * 2在MyServlet类中重写service方法
 * 3在service方法中定义具体的功能代码
 * 4在web.xml中配置Servlet的映射路径
 * 5打开浏览器请求Servlet资源
 */