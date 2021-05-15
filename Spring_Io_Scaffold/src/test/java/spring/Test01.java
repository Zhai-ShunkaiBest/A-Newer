package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.cliffside.dao.EmpDao;
import top.cliffside.pojo.Book;
import top.cliffside.pojo.User;

/**
 * @author cliffside
 * @date 2021-05-14 14:17
 */
public class Test01 {
    @Test
    public void testGetBean(){
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("springConfig.xml");

        EmpDao empDao = (EmpDao)xmlApplicationContext.getBean("empDao");
        empDao.addEmp();
    }

    @Test
    public void testGetXmlBean(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user3", User.class);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

    }
    @Test
    public void testGetFactoryBean(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beanFactoryConfig.xml");
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
    }
}
