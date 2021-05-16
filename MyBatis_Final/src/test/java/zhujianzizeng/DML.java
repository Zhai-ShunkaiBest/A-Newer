package zhujianzizeng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.cliffside.mapper.EmpMapper;
import top.cliffside.pojo.Emp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author cliffside
 * @date 2021-05-13 14:45
 */
public class DML {
    private SqlSession sqlSession;
    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb =new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory=ssfb.build(resourceAsStream) ;
        sqlSession=factory.openSession();
    }


//    @Test
//    public void testAddEmp(){
//        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        mapper.addEmp(new Emp(7938, "TOM", "SALESMAN", 7521, new Date(), 2314.0, 100.0, 10));
//        sqlSession.commit();
//    }

    @Test
    public void testUpdateEnameByEmpno(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.updateEnameByEmpno(7938, "TOM");
        sqlSession.commit();
    }

    @Test
    public void testDeletByEmpno(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.deleteByEmpno(7938);
        sqlSession.commit();
    }




    @After
    public void release(){
        // 关闭SQLSession
        sqlSession.close();
    }


}
