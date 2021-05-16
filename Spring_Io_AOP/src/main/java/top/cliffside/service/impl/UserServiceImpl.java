package top.cliffside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliffside.dao.UserDao;
import top.cliffside.service.UserService;

/**
 * @author cliffside
 * @date 2021-05-15 13:12
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int addUser(int userid, String name) {
        System.out.println("userservice add ing ...");
        userDao.addUser(userid,name);
        return 1;

    }

}
