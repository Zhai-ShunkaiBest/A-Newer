package top.cliffside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliffside.dao.DeptDao;
import top.cliffside.pojo.Dept;
import top.cliffside.service.DeptService;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:48
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public int[] deptBatchAdd(List<Dept> depts) {
        return deptDao.deptBatchAdd(depts);
    }
    @Override
    public int[] deptBatchUpdate(List<Dept> depts) {
        return  deptDao.deptBatchUpdate(depts);
    }
    @Override
    public int[] deptBatchDelete(List<Integer> deptnos) {
        return  deptDao.deptBatchDelete(deptnos);
    }
}
