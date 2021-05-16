package top.cliffside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliffside.dao.EmpDao;
import top.cliffside.service.EmpService;

/**
 * @author cliffside
 * @date 2021-05-15 13:19
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public int addEmp(Integer empno, String ename, String job) {
        empDao.addEmp(empno,ename,job);
        System.out.println("addemp adding");
        return 0;
    }
}
