package top.cliffside.dao;

import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:23
 */
public interface EmpDao {
    int findEmpCount();
    Emp findByEmpno(int empno);
    List<Emp> findByDeptno(int deptno);
    int addEmp(Emp emp);
    int updateEmp(Emp emp);
    int deleteEmp(int empno);
}
