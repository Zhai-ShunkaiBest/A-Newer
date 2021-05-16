package top.cliffside.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import top.cliffside.dao.DeptDao;
import top.cliffside.pojo.Dept;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:49
 */
public class DeptDaoImpl implements DeptDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int[] deptBatchAdd(List<Dept> depts) {
        String sql ="insert into dept values(DEFAULT,?,?)";
        List<Object[]> args =new LinkedList<>();
        for (Dept dept : depts) {
            Object[] arg ={dept.getDname(),dept.getLoc()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
    @Override
    public int[] deptBatchUpdate(List<Dept> depts) {
        String sql ="update dept set dname =? ,loc =? where deptno=?";
        List<Object[]> args =new LinkedList<>();
        for (Dept dept : depts) {
            Object[] arg ={dept.getDname(),dept.getLoc(),dept.getDeptno()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
    @Override
    public int[] deptBatchDelete(List<Integer> deptnos) {
        String sql ="delete from dept where deptno =?";
        List<Object[]> args =new LinkedList<>();
        for (Integer deptno : deptnos) {
            Object[] arg ={deptno};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
}
