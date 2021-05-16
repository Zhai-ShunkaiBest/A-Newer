package top.cliffside.service;

import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-16 20:56
 */
public interface EmpService {
    List<Emp> findByPage(Integer page,Integer pageSize);
}
