import java.lang.reflect.Method;

/**
 * @author cliffside
 * @date 2021-05-04 18:52
 */
interface Test{
    public void say();
}
interface InvokeHandler{
    Object invoke(Object obj, Method method,Object... args);
}
public class ProxyDemo {
    /**
     * 接口的创建必须使用匿名类，重写里边的方法实现
     */
    Test test = new Test() {
        @Override
        public void say() {

        }
    };

    public static void main(String[] args) {

    }
    public Test createProxyInstance(InvokeHandler handler,Class<?> clazz){
        return new Test() {
            @Override
            public void say() {
                try {
                    Method sayMethod = clazz.getMethod("say");
                    Object invoke = handler.invoke(this, sayMethod);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

            }
        };
    }
}
