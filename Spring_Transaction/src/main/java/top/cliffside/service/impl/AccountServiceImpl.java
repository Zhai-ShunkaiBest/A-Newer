package top.cliffside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cliffside.dao.AccountDao;
import top.cliffside.pojo.Account;
import top.cliffside.service.AccountService;

/**
 * @author cliffside
 * @date 2021-05-15 20:18
 * @Transactional 注解的一些参数和参数的含义
 * @Transactional(propagation = Propagation.REQUIRED,
 * isolation = Isolation.READ_UNCOMMITTED,
 * readOnly = true,
 * rollbackFor = ClassCastException.class,
 * noRollbackFor = NullPointerException.class,
 * timeout = 10)
 */
@Service
//@Transactional//加在类上,代表类中的所有方法都添加了事务控制
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    @Transactional// 放在方法上,就是仅仅对当前方法增加了事务控制
    public int transMoney(int from, int to, int money) {
        int rows=0;
        rows+=accountDao.transMoney(from, 0 - money);
        rows+=accountDao.transMoney(to, money);
        return rows;
    }
}
