package spring.AOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.cliffside.bean.User;
import top.cliffside.service.UserService;

/**
 * @author cliffside
 * @date 2021-05-14 16:02
 */
public class Test01 {
    @Test
    public void testGetBean(){
        ApplicationContext context =new ClassPathXmlApplicationContext("Config.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testGetAnnoBean(){
        ApplicationContext context =new ClassPathXmlApplicationContext("Config.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.add();
    }
}
