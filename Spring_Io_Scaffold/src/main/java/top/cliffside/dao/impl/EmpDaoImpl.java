package top.cliffside.dao.impl;

import top.cliffside.dao.EmpDao;

/**
 * @author cliffside
 * @date 2021-05-14 14:15
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp() {
        System.out.println("invoke");
        return 1;
    }
}
