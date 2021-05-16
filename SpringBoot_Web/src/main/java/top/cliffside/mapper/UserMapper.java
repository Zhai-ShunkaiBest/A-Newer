package top.cliffside.mapper;

import org.springframework.stereotype.Repository;
import top.cliffside.pojo.User;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-16 20:46
 */
@Repository
public interface UserMapper {

    List<User> findAll();
}
