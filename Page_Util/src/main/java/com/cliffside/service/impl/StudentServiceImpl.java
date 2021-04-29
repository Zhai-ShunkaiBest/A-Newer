package com.cliffside.service.impl;

import com.cliffside.dao.StudentDao;
import com.cliffside.dao.impl.StudentDaoImpl;
import com.cliffside.pojo.PageBean;
import com.cliffside.pojo.Student;
import com.cliffside.service.StudentService;
import com.cliffside.dao.StudentDao;
import com.cliffside.dao.impl.StudentDaoImpl;
import com.cliffside.pojo.PageBean;
import com.cliffside.pojo.Student;
import com.cliffside.service.StudentService;

import java.util.List;

/**
 * @Author:
 * @Description: MircoMessage:Mark_7001
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao =new StudentDaoImpl();

    // 做分页数据封装的业务处理
    @Override
    public PageBean<Student> findByPage(String stuname, String stuage, int currentPage, int pageSize) {
        // 查询出该页所有数据
        List<Student> students = studentDao.findByPage( stuname, stuage,currentPage, pageSize);
        // 查询出有多少条数据
        int totalSize =studentDao.findTotalSize( stuname, stuage);
        // 总页数
        int totalPage =totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        // 当前页
        // 页大小
        PageBean<Student> pageBean =new PageBean<>(students,  totalSize,  pageSize,  totalPage,  currentPage);

        return pageBean;
    }
}
