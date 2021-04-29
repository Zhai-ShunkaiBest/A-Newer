package com.msb.controller;

import com.msb.pojo.PageBean;
import com.msb.pojo.Student;
import com.msb.service.StudentService;
import com.msb.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
@WebServlet(urlPatterns = "/showStudentController.do")
public class ShowStudentController extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收数据
        // 页码数
        int currentPage =1;

        try {
            currentPage=Integer.parseInt(req.getParameter("currentPage"));
        } catch (NumberFormatException e) {

        }
        // 页大小
        int pageSize =5;
        try {
            pageSize =Integer.parseInt(req.getParameter("pageSize"));
        } catch (NumberFormatException e) {
        }
        // 查询条件
        String stuname = req.getParameter("stuname");
        String stuage = req.getParameter("stuage");


        // 调用service层服务处理业务逻辑
        PageBean<Student> pageBean =studentService.findByPage(stuname,stuage,currentPage,pageSize);
        // 将数据放入请求域
        req.setAttribute("pageBean",pageBean);
        req.setAttribute("stuname", stuname);
        req.setAttribute("stuage", stuage);
        // 响应数据,页面跳转
        req.getRequestDispatcher("showStudent.jsp").forward(req,resp);



    }
}
