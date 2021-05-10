import com.cliffside.pojo.Dept;
import com.cliffside.pojo.Emp;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author cliffside
 * @date 2021-05-10 16:59
 */
public class MybatisConstructors {
    public static void main(String[] args) {
        Class<Dept> deptClass = Dept.class;
        Constructor<?>[] constructors = deptClass.getConstructors();
        Object o = null;
        for (int i = 0; i <  constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            try {
                 o = constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(o);
    }

}
