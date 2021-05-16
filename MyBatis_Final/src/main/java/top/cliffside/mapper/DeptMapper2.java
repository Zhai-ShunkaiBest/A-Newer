package top.cliffside.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.cliffside.pojo.Dept;

/**
 * @author cliffside
 * @date 2021-05-13 16:35
 */
public interface DeptMapper2 {

    @Select("select * from dept where deptno =#{deptno}")
    Dept findByDeptno(int deptno);

    @Update("update dept set dname =#{dname}, loc =#{loc} where deptno =#{deptno}")
    int updateDept(Dept dept);

    @Insert("insert into dept values(DEFAULT,#{dname},#{loc})")
    int addDept(Dept dept);

    @Delete("delete from dept where deptno =#{deptno}")
    int removeDept(int deptno);


}
