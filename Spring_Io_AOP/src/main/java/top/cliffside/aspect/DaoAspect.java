package top.cliffside.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author cliffside
 * @date 2021-05-15 13:54
 */
@Aspect
@Component
@Order(2)
public class DaoAspect {
    //定义公共切点
    @Pointcut("execution(* top.cliffside.dao.*.add*(..))")
    public void addPointCut(){}
    /**
     * 前置通知: 切点方法执行之前先执行的功能
     *     * 参数列表可以用JoinPoint接收切点对象
     *     * 可以获取方法执行的参数
     * @param joinPoint ：就是addUser方法,可以获取封装了该方法信息的JoinPointer对象
     */
    @Before("execution(* top.cliffside.dao.impl.UserDaoImpl.addUser(..))")
    public void methodBefore(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();
        System.out.println("method bofore add ");
        System.out.println(Arrays.toString(args));
    }
    /**
     * 后置通知:方法执行之后要增强的功能
     * 无论切点方法是否出现异常都会执行的方法
     * 参数列表可以用JoinPoint接收切点对象
     * */
    @After("addPointCut()")
    public void methodAfter(JoinPoint joinPoint){
        System.out.println("After invoked");
    }
    /**
     * 返回通知:切点方法正常运行结束后增强的功能
     * 如果方法运行过程中出现异常,则该功能不运行
     * 参数列表可以用 JoinPoint joinPoint接收切点对象
     * 可以用Object res接收方法返回值,需要用returning指定返回值名称
     * */
    @AfterReturning( value = "addPointCut()",returning = "res")
    public void methodAfterReturning(JoinPoint joinPoint,Object res){
        System.out.println(res.toString());
        System.out.println("AfterReturning invoked");
    }
    /**
     * 异常通知:切点方法出现异常时运行的增强功能
     * 如果方法运行没有出现异常,则该功能不运行
     * 参数列表可以用Exception ex接收异常对象 需要通过throwing指定异常名称
     * */
    @AfterThrowing( value = "addPointCut()",throwing = "ex")
    public void methodAfterThrowing(Exception ex){

        System.out.println(ex.toString());
        System.out.println("AfterThrowing invoked");
    }

    /**
     * 环绕通知:在切点方法之前和之后都进行功能的增强
     * 需要在通知中定义方法执行的位置,并在执行位置之前和之后自定义增强的功能
     * 方法列表可以通过ProceedingJoinPoint获取执行的切点
     * 通过proceedingJoinPoint.proceed()方法控制切点方法的执行位置
     * proceedingJoinPoint.proceed()方法会将切点方法的返回值获取到,并交给我们,可以做后续处理
     * 我们在环绕通知的最后需要将切点方法的返回值继续向上返回,否则切点方法在执行时接收不到返回值
     * */
    @Around("addPointCut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundA---------- invoked");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("aroundB---------- invoked");
        return proceed;
    }
}
