package com.cliffside.mapper;

import com.cliffside.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author cliffside
 * @date 2021-04-30 11:24
 */
public interface EmpMapper {
    Emp findOne();
    /**
     * 该方法用于查询全部的员工信息
     * @return 全部员工信息封装的Emp对象的List集合
     */
    @Select("")
    List<Emp> findAll();
    /**
     * 根据员工编号查询单个员工信息的方法
     * @param empno 员工编号
     * @return 如果找到了返回Emp对象,找不到返回null
     */
    Emp findByEmpno(int empno);


    /**
     * 根据员工编号和薪资下限去查询员工信息
     * @param sal 薪资下限
     * @return 多个Emp对象的List集合
     */
    List<Emp> findByDeptnoAndSal(@Param("deptno") int deptno, @Param("sal") double sal);

    List<Emp> findByDeptnoAndSal2(Map<String,Object> map);

    List<Emp> findByDeptnoAndSal3(Emp emp);

    List<Emp> findByDeptnoAndSal4(@Param("empa") Emp empa,@Param("empb") Emp empb);

    /**
     * 根据名字做模糊查询
     * @param name 模糊查询的文字
     * @return  Emp对象List集合
     */
    List<Emp> findByEname(String name);


}
