package top.cliffside.mapper;

import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 14:50
 */
public interface EmpMapper2 {
    List<Emp> findByCondition(Emp emp);

    int updateEmpByCondtion();

    int updateEmpByCondition2(int empno);
}
