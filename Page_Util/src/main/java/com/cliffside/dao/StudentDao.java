package com.cliffside.dao;

import com.cliffside.pojo.Student;

import java.util.List;

/**
 * @Author:
 * @Description: MircoMessage:Mark_7001
 */
public interface StudentDao {
    List<Student> findByPage(String stuname,String stuage,int currentPage, int pageSize);

    int findTotalSize(String stuname,String stuage);
}
