package top.cliffside.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author cliffside
 * @date 2021-05-15 18:54
 */
@Configuration
@ComponentScan("top.cliffside")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAOPconfig {
}
