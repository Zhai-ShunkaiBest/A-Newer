package com.msb.dao;

import com.msb.pojo.Student;

import java.util.List;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public interface StudentDao {
    List<Student> findByPage(String stuname,String stuage,int currentPage, int pageSize);

    int findTotalSize(String stuname,String stuage);
}
