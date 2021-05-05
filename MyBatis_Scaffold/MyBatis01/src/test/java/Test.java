import com.cliffside.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author cliffside
 * @date 2021-04-30 9:39
 */
public class Test {
    private SqlSession sqlSession;
    @Before
    public void init(){
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = sessionFactoryBuilder.build(resourceAsStream);
        sqlSession = build.openSession();

    }
    @org.junit.Test
    public void testFindAll(){
        List<Dept> findAll = sqlSession.selectList("findAll");
        for (Dept d : findAll) {
            System.out.println(d);
        }
    }

    @After
    public void release(){
        sqlSession.close();
    }
}
