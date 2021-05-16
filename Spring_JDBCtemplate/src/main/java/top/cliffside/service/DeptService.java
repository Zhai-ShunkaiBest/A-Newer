package top.cliffside.service;

import top.cliffside.pojo.Dept;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:48
 */
public interface DeptService {
    int[] deptBatchAdd(List<Dept> depts);
    int[] deptBatchUpdate(List<Dept> depts);
    int[] deptBatchDelete(List<Integer> deptnos);

}
