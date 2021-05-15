package spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.plaf.PanelUI;

/**
 * @author cliffside
 * @date 2021-05-14 15:53
 */
public class Test03 {
    @Test
    public void testGetBean(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("druidConfig.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.toString());
    }
}
