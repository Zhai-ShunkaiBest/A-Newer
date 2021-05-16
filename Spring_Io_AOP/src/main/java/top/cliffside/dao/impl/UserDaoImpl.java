package top.cliffside.dao.impl;

import org.springframework.stereotype.Repository;
import top.cliffside.dao.UserDao;

/**
 * @author cliffside
 * @date 2021-05-15 13:14
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(int userid, String name) {
        System.out.println("userdao add ing");
        //int i = 1/0;
        return 1;
    }

    @Override
    public int updateUser(int userid, String username) {
        return 0;
    }
}
