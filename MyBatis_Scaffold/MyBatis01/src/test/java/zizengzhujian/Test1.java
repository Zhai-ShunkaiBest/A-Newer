package zizengzhujian;

import com.cliffside.mapper.DeptMapper;

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
 * @date 2021-05-13 13:43
 */
public class Test1 {
    private SqlSession sqlSession;

    @Test
    public void testFindAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept =new Dept(null,"AI学院","北京");
        int i = mapper.addDept2(dept);
        System.out.println(i);
        System.out.println(dept.getDeptno());
        sqlSession.close();

    }
}
