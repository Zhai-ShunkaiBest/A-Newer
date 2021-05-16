package test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.cliffside.config.SpringAOPconfig;
import top.cliffside.dao.UserDao;
import top.cliffside.service.EmpService;
import top.cliffside.service.UserService;

/**
 * @author cliffside
 * @date 2021-05-15 14:23
 */
public class TestIOC {
    @Test
    public  void testGetBean(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("AOPConfig.xml");
        //UserService bean = classPathXmlApplicationContext.getBean("UserServiceImpl",UserService.class);
        EmpService bean = classPathXmlApplicationContext.getBean(EmpService.class);
        bean.addEmp(1,"name","alibaba");
        //UserDao bean1 = classPathXmlApplicationContext.getBean(UserDao.class);
        System.out.println(bean.getClass().getSimpleName());
        //System.out.println(bean1.getClass().getSimpleName());
    }

    @Test
    public  void testGetConfigBean(){
        ConfigurableApplicationContext configurableApplicationContext = new AnnotationConfigApplicationContext(SpringAOPconfig.class);
        UserDao bean = configurableApplicationContext.getBean(UserDao.class);
        bean.addUser(222,"bytedance");
    }
}
