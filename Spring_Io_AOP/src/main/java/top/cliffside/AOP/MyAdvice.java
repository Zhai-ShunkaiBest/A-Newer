package top.cliffside.AOP;

/**
 * @author cliffside
 * @date 2021-05-15 13:45
 * 切入点表达式: 通过一个表达式来确定AOP要增强的是哪个或者那些方法
 * 语法结构:execution([权限修饰符][返回值类型][类的全路径名][方法名](参数 列表) )
 * 例子1
 * execution(* com.msb.dao.UserDaoImpl.add(..))  //指定切点为UserDaoImpl.add方法
 * execution(* com.msb.dao.UserDaoImpl.*(..))    //指定切点为UserDaoImpl.所有的方法
 * execution(* com.msb.dao.*.*(..))              //指定切点为dao包下所有的类中的所有的方法
 * execution(* com.msb.dao.*.add(..))            // 指定切点为dao包下所有的类中的add的方法
 * execution(* com.msb.dao.*.add*(..))           // 指定切点为dao包下所有的类中的add开头的方法
 */
public class MyAdvice {
    //获取系统时间
    public void  getStartTime(){

    }
    //获取系统时间和上次的时间差
    public void getEndTime(){

    }
}
