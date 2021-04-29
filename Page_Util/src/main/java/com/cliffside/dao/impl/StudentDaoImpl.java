package com.cliffside.dao.impl;

import com.cliffside.dao.StudentDao;
import com.cliffside.pojo.Student;
import com.cliffside.dao.StudentDao;
import com.cliffside.pojo.Student;

import java.util.List;

/**
 * @Author:
 * @Description: MircoMessage:Mark_7001
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<Student> findByPage(String stuname, String stuage, int currentPage, int pageSize) {
        StringBuilder sql=new StringBuilder("select  * from student where 1=1 ");
        if(null != stuname && !"".equals(stuname)) {
            sql.append("and stuname like ? ");
        }
        if(null != stuage && !"".equals(stuage)) {
            sql.append("and stuage > ? ");
        }
        sql.append("limit ?,?");
        System.out.println(sql.toString());
        List list =null;
        if(null != stuname && !"".equals(stuname) && null != stuage && !"".equals(stuage)){
             list = baseQuery(Student.class, sql.toString(), "%"+stuname+"%",stuage,(currentPage - 1) * pageSize, pageSize);
        }else if ((null != stuname && !"".equals(stuname)) && (null == stuage || "".equals(stuage))){
             list = baseQuery(Student.class, sql.toString(), "%"+stuname+"%",(currentPage - 1) * pageSize, pageSize);
        }else if ((null == stuname || "".equals(stuname))&& (null != stuage && !"".equals(stuage))){
             list = baseQuery(Student.class, sql.toString(), stuage,(currentPage - 1) * pageSize, pageSize);
        }else{
             list = baseQuery(Student.class, sql.toString(), (currentPage - 1) * pageSize, pageSize);
        }
        return list;
    }

    @Override
    public int findTotalSize(String stuname,String stuage) {
        StringBuilder sql=new StringBuilder("select  count(1) from student where 1=1 ");
        if(null != stuname && !"".equals(stuname)) {
            sql.append("and stuname like ? ");
        }
        if(null != stuage && !"".equals(stuage)) {
            sql.append("and stuage > ? ");
        }

        int count =0;
        if(null != stuname && !"".equals(stuname) && null != stuage && !"".equals(stuage)){
            count = baseQueryInt( sql.toString(), "%"+stuname+"%",stuage);
        }else if ((null != stuname && !"".equals(stuname)) && (null == stuage || "".equals(stuage))){
            count = baseQueryInt( sql.toString(), "%"+stuname+"%");

        }else if ((null == stuname || "".equals(stuname))&& (null != stuage && !"".equals(stuage))){
            count = baseQueryInt( sql.toString(),stuage);
        }else{
            count = baseQueryInt(sql.toString());
        }
        return count;
    }
}
