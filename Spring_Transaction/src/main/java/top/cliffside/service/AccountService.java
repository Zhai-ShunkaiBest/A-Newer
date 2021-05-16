package top.cliffside.service;

/**
 * @author cliffside
 * @date 2021-05-15 20:17
 * 事务的管理应该放在我们的service层进行处理
 * spring中有两种事务的管理方式
 * 1 编程式事务管理(了解)
 * 2 声明式事务管理(掌握)
 *         基于注解方式实现(掌握)
 *   XML方式实现(了解)
 *   Spring声明式事务的实现方式,底层就是AOP,AOP的底层就是动态代理
 *
 *   Spring事务管理相关的API
 *
 * 事务管理器接口: PlatformTransactionManager  针对不同的框架,提供了不同的实现类
 */
public interface AccountService {

    int transMoney(int from ,int to,int money);
}
