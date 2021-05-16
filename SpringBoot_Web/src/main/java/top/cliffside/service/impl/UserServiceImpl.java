package top.cliffside.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cliffside.mapper.UserMapper;
import top.cliffside.pojo.User;
import top.cliffside.service.UserService;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-16 20:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
