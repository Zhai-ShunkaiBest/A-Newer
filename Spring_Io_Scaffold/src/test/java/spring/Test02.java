package spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.cliffside.pojo.Emp;
import top.cliffside.pojo.User;

/**
 * @author cliffside
 * @date 2021-05-14 15:27
 */
public class Test02 {
    @Test
    public void testGetBean(){
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("springConfig.xml");
        User user = context.getBean("user", User.class);
        System.out.println("第四步:User对象从容器中获取");
        // 关闭容器
        context.close();
    }

    @Test
    public void testGetEmpBean(){
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Dept2EmpBean.xml");
        Emp emp = context.getBean("emp2", Emp.class);
        System.out.println(emp);
    }
}
