import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.cliffside.config.SpringConfig;
import top.cliffside.pojo.Account;
import top.cliffside.service.AccountService;

/**
 * @author cliffside
 * @date 2021-05-15 20:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTx {
    @Autowired
    private AccountService accountService;
    @Test
    public void  test(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);
    }
    @Test()
    public void testTransaction3(){
        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean(AccountService.class);
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);
    }


}

