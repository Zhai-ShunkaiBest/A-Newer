package top.cliffside.dao;

import org.springframework.stereotype.Repository;
import top.cliffside.pojo.Dept;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:49
 */
@Repository
public interface DeptDao {
    int[] deptBatchAdd(List<Dept> depts);
    int[] deptBatchUpdate(List<Dept> depts);
    int[] deptBatchDelete(List<Integer> deptnos);
}
