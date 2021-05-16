package top.cliffside.mapper;

import org.springframework.stereotype.Repository;
import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-16 20:59
 */
@Repository
public interface EmpMapper {
    List<Emp> findAll();
}
