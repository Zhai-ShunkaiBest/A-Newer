package top.cliffside.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.cliffside.dao.EmpDao;
import top.cliffside.pojo.Emp;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:23
 */
@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int findEmpCount() {
        /*查询员工个数
         * queryForObject 两个参数
         * 1 SQL语句
         * 2 返回值类型
         *
         * */
        Integer empCount = jdbcTemplate.queryForObject("select count(1) from emp", Integer.class);
        return empCount;
    }
    @Override
    public Emp findByEmpno(int empno) {
        /*
         * 查询单个员工对象
         * queryForObject三个参数
         * 1 SQL语句
         * 2 RowMapper接口的实现类对象,用于执行返回的结果用哪个类来进行封装 ,实现类为BeanPropertyRowMapper
         * 3 SQL语句中需要的参数 (可变参数)
         * */
        BeanPropertyRowMapper<Emp> rowMapper =new BeanPropertyRowMapper<>(Emp.class);
        Emp emp = jdbcTemplate.queryForObject("select * from emp where empno =?", rowMapper, empno);
        return emp;
    }
    @Override
    public List<Emp> findByDeptno(int deptno) {
        /*
         * 查询单个员工对象
         * query三个参数
         * 1 SQL语句
         * 2 RowMapper接口的实现类对象,用于执行返回的结果用哪个类来进行封装 ,实现类为BeanPropertyRowMapper
         * 3 SQL语句中需要的参数 (可变参数)
         * */
        BeanPropertyRowMapper<Emp> rowMapper =new BeanPropertyRowMapper<>(Emp.class);
        List<Emp> emps = jdbcTemplate.query("select * from emp where deptno =?", rowMapper, deptno);
        return emps;
    }
    @Override
    public int addEmp(Emp emp) {
        /*增删改
         * 统统用update方法 两个参数
         * 1 SQL语句
         * 2 SQL语句需要的参数 (可变参数)
         *
         * */
        String sql ="insert into emp values(DEFAULT ,?,?,?,?,?,?,?)";
        Object[] args ={emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
        return jdbcTemplate.update(sql,args);
    }
    @Override
    public int updateEmp(Emp emp) {
        String sql ="update emp set ename =? , job =?, mgr=? , hiredate =?, sal=?, comm=?, deptno =? where empno =?";
        Object[] args ={emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        return jdbcTemplate.update(sql,args);
    }
    @Override
    public int deleteEmp(int empno) {
        String sql ="delete  from emp where empno =?";
        return jdbcTemplate.update(sql, empno);
    }
}
