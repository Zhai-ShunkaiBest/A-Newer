package top.cliffside.bean;

import org.springframework.stereotype.Component;

/**
 * @author cliffside
 * @date 2021-05-14 16:01
 * @Component 放在类上, 用于标记, 告诉spring当前类需要由容器实例化bean并放入容器中
 *   该注解有三个子注解
 *   @Controller 用于实例化controller层bean
 *         @Service 用于实例化service层bean
 *         @Repository 用于实例化持久层bean
 *   当不确定是哪一层,就用Component
 * 这几个注解互相混用其实也可以,但是不推荐
 *
 * 2注解方式依赖注入DI
 *
 * @Autowired 根据属性数据类型自动装配
 * @Qualifier 根据属性名称注入依赖
 * @Resources 可以根据类型, 也可以根据名称注入
 * @Value 注入普通数据类型(8 + String)
 */
@Component(value = "user")
public class User {
}
