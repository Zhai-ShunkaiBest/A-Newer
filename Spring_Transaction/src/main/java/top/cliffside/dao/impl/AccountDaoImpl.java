package top.cliffside.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.cliffside.dao.AccountDao;

/**
 * @author cliffside
 * @date 2021-05-15 20:16
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int transMoney(int id, int money) {
        String sql ="update account set money =money +? where id =?";
        return jdbcTemplate.update(sql,money,id);
    }
}
