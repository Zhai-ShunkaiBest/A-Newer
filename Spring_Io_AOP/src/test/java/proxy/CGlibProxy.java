package proxy;


import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cliffside
 * @date 2021-05-14 22:37
 */
public class CGlibProxy {
    @Test
    public void testCGlib(){
        User user = new User("zhangsan");
        // 1 获得一个Enhancer对象
        Enhancer enhancer=new Enhancer();
        // 2 设置父类字节码
        enhancer.setSuperclass(user.getClass());
        // 3 获取MethodIntercepter对象 用于定义增强规则
        MethodInterceptor methodInterceptor=new MethodInterceptor(){
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                /*Object o,  生成之后的代理对象 userProxy
                Method method,  父类中原本要执行的方法  User>>> eat()
                Object[] objects, 方法在调用时传入的实参数组
                MethodProxy methodProxy  子类中重写父类的方法 personProxy >>> eat()
                */
                Object res =null;
                if(method.getName().equals("eat")){
                    // 如果是eat方法 则增强并运行
                    System.out.println("饭前洗手");
                    res=methodProxy.invokeSuper(o,objects);
                    System.out.println("饭后刷碗");
                }else{
                    // 如果是其他方法 不增强运行
                    res=methodProxy.invokeSuper(o,objects); // 子类对象方法在执行,默认会调用父类对应被重写的方法
                }
                return res;
            }
        };
        // 4 设置methodInterceptor
        enhancer.setCallback(methodInterceptor);
        // 5 获得代理对象
        User userProxy = (User) enhancer.create();
        // 6 使用代理对象完成功能
        userProxy.sleep();

    }
}

class User{
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void est(String food){
        System.out.println(name+"正在吃"+food);
    }

    public void sleep(){
        System.out.println(name+"正在sleep");
    }
}

class Son extends User{
    public Son(String name) {
        super(name);
    }

    @Override
    public void est(String food) {
        System.out.println("洗手ed");
        super.est(food);
        System.out.println("洗碗ing");
    }
}
