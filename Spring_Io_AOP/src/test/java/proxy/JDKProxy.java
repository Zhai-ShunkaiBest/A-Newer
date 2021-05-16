package proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author cliffside
 * @date 2021-05-14 22:07
 */
public class JDKProxy {
    @Test
    public  void testEat(){
        Man zhangsan = new Man("zhangsan");
        //通过Proxy动态代理获得一个代理对象，在代理对象中对某个方法增强
        /**
         * ClassLoader loader 被代理对象的类加载器
         * Class<?>[] interfaces被代理对象所实现的所有接口
         * InvocationHandler handler，执行处理器对象，专门用于定义增强的规则
         */
        Dinner dinnerProxy = (Dinner) Proxy.newProxyInstance(zhangsan.getClass().getClassLoader(),
                zhangsan.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     *
                     * @param proxy : 代理对象dinnerProxy
                     * @param method：被代理的方法
                     * @param args： 被代理方法运行的实参
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object o = null;
                        System.out.println(Arrays.toString(args));
                        if (method.getName().equals("eat")) {
                            System.out.println("饭钱洗手");
                            o = method.invoke(zhangsan,args);
                        }

                        System.out.println("我正在处理jdk动态代理");
                        return o;
                    }
                });
        zhangsan.eat("面条");

        dinnerProxy.eat("米饭");
    }
}


interface  Dinner{
    void eat(String food);
}

class Man implements Dinner{

    private String eat;

    public Man(String eat) {
        this.eat = eat;
    }

    @Override
    public void eat(String food) {
        System.out.println(eat+"正在吃"+food);
    }
}