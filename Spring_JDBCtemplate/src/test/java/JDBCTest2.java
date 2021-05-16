import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.cliffside.pojo.Dept;
import top.cliffside.service.DeptService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-15 19:50
 */
public class JDBCTest2 {
    @Test
    public void testBatchAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = context.getBean(DeptService.class);
        List<Dept> depts =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            depts.add(new Dept(null,"name"+i,"loc"+i));
        }
        int[] ints = deptService.deptBatchAdd(depts);
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void testBatchUpdate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = context.getBean(DeptService.class);
        List<Dept> depts =new ArrayList<>();
        for (int i = 51; i <=60; i++) {
            depts.add(new Dept(i,"newname","newLoc"));
        }
        int[] ints = deptService.deptBatchUpdate(depts);
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void testBatchDelete(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = context.getBean(DeptService.class);
        List<Integer> deptnos =new ArrayList<>();
        for (int i = 51; i <=69; i++) {
            deptnos.add(i);
        }
        int[] ints = deptService.deptBatchDelete(deptnos);
        System.out.println(Arrays.toString(ints));
    }
}
