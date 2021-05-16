package top.cliffside.dao;

import org.springframework.stereotype.Repository;

/**
 * @author cliffside
 * @date 2021-05-15 13:08
 */
@Repository
public interface UserDao {
    int addUser(int userid, String name);

    int updateUser(int userid,String username);
}
