package top.cliffside.service;

import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:22
 */
public interface EmpService {
    int findEmpCount();

    Emp findByEmpno(int empno);

    List<Emp> findByDeptno(int deptno);

    int  addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp( int empno);
}
