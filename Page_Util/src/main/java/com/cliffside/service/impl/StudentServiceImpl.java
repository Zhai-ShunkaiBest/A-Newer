package com.msb.service.impl;

import com.msb.dao.StudentDao;
import com.msb.dao.impl.StudentDaoImpl;
import com.msb.pojo.PageBean;
import com.msb.pojo.Student;
import com.msb.service.StudentService;

import java.util.List;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao =new StudentDaoImpl();

    // 做分页数据封装的业务处理
    @Override
    public PageBean<Student> findByPage(String stuname,String stuage,int currentPage, int pageSize) {
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
