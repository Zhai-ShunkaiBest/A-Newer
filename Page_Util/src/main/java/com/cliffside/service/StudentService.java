package com.cliffside.service;

import com.cliffside.pojo.PageBean;
import com.cliffside.pojo.Student;

/**
 * @Author:
 * @Description: MircoMessage:Mark_7001
 */
public interface StudentService {
    PageBean<Student> findByPage(String stuname,String stuage ,int currentPage, int pageSize);
}
