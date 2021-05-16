package dongtai;

import org.apache.ibatis.session.SqlSession;
import top.cliffside.mapper.EmpMapper2;
import top.cliffside.pojo.Emp;
import top.cliffside.util.SqlSessionUtil;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 14:53
 */
public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp condition =new Emp();
        condition.setDeptno(20);
        /* condition.setSal(3000.0);*/
        /*condition.setHiredate(new java.sql.Date(81,1,22));*/
        //condition.setComm(0.0);
        //condition.setDeptno(20);
        List<Emp> emps = mapper. findByCondition(condition);
        for (Emp e:emps
        ) {
            System.out.println(e);
        }

    }
}
