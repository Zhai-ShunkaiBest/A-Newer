package com.msb.service;

import com.msb.pojo.PageBean;
import com.msb.pojo.Student;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public interface StudentService {
    PageBean<Student> findByPage(String stuname,String stuage ,int currentPage, int pageSize);
}
