package top.cliffside.mapper;

import top.cliffside.pojo.Dept;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 14:27
 */
public interface DeptMapper {

    int addDept(Dept dept);

    int addDept2(Dept dept);

    /**
     * 根据部门编号查询部门信息及该部分的所有员工信息
     * @param deptno 要查询的部门编号
     * @return Dept对象,内部组合了一个Emp的List属性用于封装部门的所有员工信息
     */
    List<Dept> findDeptJoinEmpsByDeptno(int deptno);

    Dept findDeptByDeptno(int deptno);


}
