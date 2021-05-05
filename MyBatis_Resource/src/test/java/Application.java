import com.cliffside.pojo.Emp;
import com.google.common.collect.Maps;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cliffside
 * @date 2021-05-04 15:56
 */
interface UserMapper{
    @Select("SELECT * FROM emp WHERE id = #{empno}")
    List<Emp> selectUserList(Integer empno, String ename);
}
public class Application {
    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(Application.class.getClassLoader(),
                new Class<?>[]{UserMapper.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Select annotation = method.getAnnotation(Select.class);
                        System.out.println(method.getName());
                        System.out.println(Arrays.toString(args));
                        Map<String, Object> nameArgMap = buildMethodArgNameMap(method, args);

                        if (annotation != null) {
                            String[] value = annotation.value();
                            System.out.println(Arrays.toString(value));
                            String argOfSQL= value[0];
                            String s = parseSQL(argOfSQL, nameArgMap);
                            System.out.println(s);
                        }
                        return null;
                    }
                });
        userMapper.selectUserList(1,"jack");
    }
    public static Map<String,Object> buildMethodArgNameMap(Method method,Object[] args){
        Map<String,Object> map = Maps.newHashMap();
        Parameter[] parameters = method.getParameters();

        System.out.println("-----------------"+Arrays.toString(parameters));
        Arrays.asList(parameters).forEach(parameter -> {
            Class<?> type = parameter.getType();
            System.out.println(type.toString());
        });
        AtomicInteger index = new AtomicInteger(0);
        Arrays.asList(parameters).forEach(parameter -> {
            String name = parameter.getName();
            System.out.println(name);
            map.put(name,args[index.get()]);
            //System.out.println("increment before:"+index.get());
            index.getAndIncrement();
            //System.out.println("increment after:"+index.get());
        });
        System.out.println(map.toString());
        return map;
    }

    public static String parseSQL(String sql,Map<String,Object> nameArgMap){
       // String parseSQL ="";
        StringBuilder stringBuilder = new StringBuilder();
        int length = sql.length();
        for (int i =0;i<length;i++){
            char c = sql.charAt(i);
            if (c == '#'){
                int nextIndex = i+1;
                char nextChar = sql.charAt(nextIndex);
                if (nextChar != '{'){
                    throw new RuntimeException(String.format("这里应该是#{"));
                }
                StringBuilder argStringBuilder= new StringBuilder();
                i = parseArgSQL(argStringBuilder,sql,nextIndex);
                String s = argStringBuilder.toString();
                Object argValue = nameArgMap.get("arg0");
                System.out.println(s);
                stringBuilder.append(argValue.toString());
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static int parseArgSQL(StringBuilder argStringBuilder, String sql,int nextIndex) {
        nextIndex++;
        for (;nextIndex<sql.length();nextIndex++){
            char c = sql.charAt(nextIndex);
            if (c!='}') {
                argStringBuilder.append(c);
            }
            if (c=='}'){
                return nextIndex;
            }
        }
        throw new RuntimeException(String.format("缺少有大括号}"));
    }


}
