package top.cliffside.dao.impl;

import org.springframework.stereotype.Repository;
import top.cliffside.bean.User;
import top.cliffside.dao.UserDao;

/**
 * @author cliffside
 * @date 2021-05-14 16:20
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {

        System.out.println(".................");
    }
}
