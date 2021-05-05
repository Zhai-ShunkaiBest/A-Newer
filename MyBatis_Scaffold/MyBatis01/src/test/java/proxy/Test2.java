package proxy;
import com.cliffside.mapper.EmpMapper;
import com.cliffside.pojo.Dept;
import com.cliffside.pojo.Emp;
import com.cliffside.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author cliffside
 * @date 2021-04-30 11:52
 */
public class Test2 {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        /*
         * 帮助我们生成一个接口下的实现类对象的
         *
         * */
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.findAll();
        for(Emp emp:emps) {
            System.out.println(emp);
        }
        // 1单个基本数据类型作为方法参数
        Emp emp = mapper.findByEmpno(7902);
        System.out.println(emp);
        // 2多个基本数据类型作为方法参数
        List<Emp> emps2 = mapper.findByDeptnoAndSal(10, 1500);
        for(Emp em:emps2) {
            System.out.println(em);
        }
        // 3单个引用类型作为方法参数
        Emp condition=new Emp();
        condition.setDeptno(10);
        condition.setSal(1500.0);
        List<Emp> emps3 = mapper.findByDeptnoAndSal3(condition);
        for(Emp em:emps3) {
            System.out.println(em);
        }

        // 4多个引用类型作为方法参数
        Emp condition1=new Emp();
        condition1.setDeptno(10);
        Emp condition2=new Emp();
        condition2.setSal(1500.0);
        List<Emp> emps4 = mapper.findByDeptnoAndSal4(condition1,condition2);
        for(Emp em:emps4) {
            System.out.println(em);
        }
        sqlSession.close();
    }

}
