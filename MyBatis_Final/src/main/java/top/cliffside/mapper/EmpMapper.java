package top.cliffside.mapper;

import org.apache.ibatis.annotations.Param;
import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 14:27
 */
public interface EmpMapper {
    int addEmp(Emp emp);

    int updateEnameByEmpno(@Param("empno") int empno,@Param("ename") String ename);

    int deleteByEmpno(int empno);

    /**
     * 根据员工编号查询员工的所有信息并携带所在的部门信息
     * @param empno 要查询的员工编号
     * @return Emp对象,组合了Dept对象作为属性,对部门信息进行存储
     */
    Emp findEmpJoinDeptByEmpno(int empno);

    List<Emp> findEmpsByDeptno(int deptno);
}
