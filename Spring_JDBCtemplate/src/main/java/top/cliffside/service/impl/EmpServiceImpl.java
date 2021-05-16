package top.cliffside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliffside.dao.EmpDao;
import top.cliffside.pojo.Emp;
import top.cliffside.service.EmpService;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:22
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    public int findEmpCount() {
        return empDao.findEmpCount();
    }
    @Override
    public Emp findByEmpno(int empno) {
        return empDao.findByEmpno( empno);
    }
    @Override
    public List<Emp> findByDeptno(int deptno) {
        return empDao.findByDeptno( deptno);
    }
    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }
    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }
    @Override
    public int deleteEmp(int empno) {
        return empDao.deleteEmp(empno);
    }
}
