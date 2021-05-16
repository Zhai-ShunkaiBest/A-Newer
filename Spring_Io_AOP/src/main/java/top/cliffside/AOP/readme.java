package top.cliffside.AOP;

/**
 * @author cliffside
 * @date 2021-05-15 13:06
 * AOP切面编程一般可以帮助我们在不修改现有代码的情况下,
 * 对程序的功能进行拓展,往往用于实现 日志处理,权限控制,性能检测,事务控制等
 * AOP实现的原理就是动态代理,在有接口的情况下,使用JDK动态代理,
 * 在没有接口的情况下使用cglib动态代理
 */
public class  readme {
}
/**
 * AOP中的术语辨析
 *
 * 1 连接点 Joint point:
 * 类里面那些可以被增强的方法,这些方法称之为连接点
 * 表示在程序中明确定义的点，典型的包括方法调用，
 * 对类成员的访问以及异常处理程序块的执行等等，
 * 它自身还可以嵌套其它 joint point
 *
 *
 * 2 切入点 Pointcut:
 * 实际被增强的方法,称之为切入点
 * 表示一组 joint point，这些 joint point 或是通过逻辑关系组合起来，
 * 或是通过通配、正则表达式等方式集中起来，它定义了相应的 Advice 将要发生的地方
 *
 * 3 通知 Advice:
 * 实际增强的逻辑部分称为通知 (增加的功能)
 * Advice 定义了在 Pointcut 里面定义的程序点具体要做的操作，
 * 它通过 before、after 和 around 来区别是在每个 joint point
 * 之前、之后还是代替执行的代码。
 * 通知类型: 1 前置通知 2 后置通知 3 环绕通知 4 异常通知 5 最终通知
 *
 * 4 目标对象 Target：被增强功能的对象(被代理的对象)
 * 织入 Advice 的目标对象
 *
 * 5 切面Aspect： 表现为功能相关的一些advice方法放在一起声明成的一个Java类
 * Aspect 声明类似于 Java 中的类声明，在 Aspect 中会包含着一些 Pointcut 以及相应的 Advice。
 *
 * 6 织入 Weaving：
 * 创建代理对象并实现功能增强的声明并运行过程
 * 将 Aspect 和其他对象连接起来, 并创建 Adviced object 的过程
 */