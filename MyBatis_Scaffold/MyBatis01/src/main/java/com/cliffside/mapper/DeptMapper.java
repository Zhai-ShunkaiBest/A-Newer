package com.cliffside.mapper;

import com.cliffside.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 13:35
 */
@Mapper
public interface DeptMapper {

    int addDept(Dept dept);

    int addDept2(Dept dept);

    List<Dept> findAll();
}
