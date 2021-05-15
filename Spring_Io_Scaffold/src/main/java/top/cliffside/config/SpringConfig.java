package top.cliffside.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author cliffside
 * @date 2021-05-14 16:40
 */
@ComponentScan(basePackages = "top.cliffside")
@PropertySource("classpath:config.properties")
public class SpringConfig {
}
