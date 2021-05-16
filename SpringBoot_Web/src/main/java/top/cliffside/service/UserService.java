package top.cliffside.service;

import top.cliffside.pojo.User;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-16 20:43
 */
public interface UserService {
    List<User> findAll();
}
