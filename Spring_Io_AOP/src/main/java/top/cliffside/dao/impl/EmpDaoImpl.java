package top.cliffside.dao.impl;

import org.springframework.stereotype.Repository;
import top.cliffside.dao.EmpDao;

/**
 * @author cliffside
 * @date 2021-05-15 13:18
 */
@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp(Integer empno, String ename, String job) {
        System.out.println("empDao add ... ...");
        return 1;
    }
}
