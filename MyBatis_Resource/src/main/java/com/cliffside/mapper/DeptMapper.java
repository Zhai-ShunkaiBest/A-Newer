package com.cliffside.mapper;

import com.cliffside.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-05 21:01
 */
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> select();
}
