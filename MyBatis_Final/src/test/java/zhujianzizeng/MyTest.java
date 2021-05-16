package zhujianzizeng;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.cliffside.mapper.DeptMapper;
import top.cliffside.mapper.EmpMapper;
import top.cliffside.mapper.ProjectMapper;
import top.cliffside.pojo.Dept;
import top.cliffside.pojo.Emp;
import top.cliffside.pojo.Project;
import top.cliffside.pojo.ProjectRecord;
import top.cliffside.util.SqlSessionUtil;

import java.text.ParseException;
import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-13 14:31
 * 方式1
 * useGeneratedKeys：表示要使用自增的主键
 * keyProperty：表示把自增的主键赋给JavaBean的哪个成员变量。
 * 以添加Dept对象为例，添加前Dept对象的deptno是空的，添加完毕后可以通过getDeptno() 获取自增的主键。
 * 方式2
 * order：取值AFTER|BEFORE，表示在新增之后|之前执行<selectKey>中的SQL命令
 * keyProperty：执行select @@identity后结果填充到哪个属性中
 * resultType：结果类型。
 */
public class MyTest {
    @Test
    public void mytest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept =new Dept(null,"AI学院","北京",null);
        int i = mapper.addDept(dept);
        System.out.println(i);
        System.out.println(dept.getDeptno());
        sqlSession.close();

    }
    @Test
    public void mytest2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept =new Dept(null,"AI学院","北京",null);
        int i = mapper.addDept2(dept);
        System.out.println(i);
        System.out.println(dept.getDeptno());
        sqlSession.close();

    }
    @Test
    public void testOneToOne() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findEmpJoinDeptByEmpno(7499);
        System.out.println(emp);
    }

    @Test
    public void testOneToMany() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = mapper.findDeptJoinEmpsByDeptno(20);
        System.out.println(list);
        System.out.println("---------");

        for (Dept d : list) {
            List<Emp> empList = d.getEmpList();
            if (empList!=null){
                empList.forEach(System.out::println);
            }
        }
    }
    @Test
    public void testManyToMany() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = mapper.findProjectJoinEmpsByPid(2);
        System.out.println(project.getPid());
        System.out.println(project.getPname());
        System.out.println(project.getMoney());

        List<ProjectRecord> projectRecords = project.getProjectRecords();
        for (ProjectRecord projectRecord : projectRecords) {
            Emp emp = projectRecord.getEmp();
            System.out.println(emp);
        }
    }

    @Test
    public void testFindDeptByDeptno(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.findDeptByDeptno(20);
        System.out.println(dept.getDname());
        System.out.println(dept.getDeptno());
        System.out.println(dept.getLoc());
        List<Emp> empList = dept.getEmpList();
        empList.forEach(System.out::println);
    }


}
/**
 * 技术扩展
 * 在很多应用场景中需要新增数据后获取到新增数据的主键值，针对这样的需求一般由三种解决方式：
 * 	主键自定义，用户通过UUID或时间戳等方式生成唯一主键，把这个值当做主键值。在分布式场景中应用较多。
 * 	查询后通过select max(主键) from 表获取主键最大值。这种方式在多线程访问情况下可能出现问题。
 * 	查询后通过select @@identity获取最新生成主键。要求这条SQL必须在insert操作之后，且数据库连接没有关闭。
 */