import com.cliffside.pojo.Dept;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author cliffside
 * @date 2021-05-10 17:07
 */
public class BlackMagic {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);

        Unsafe unsafe=(Unsafe) theUnsafe.get(null);

        Dept dept= (Dept)unsafe.allocateInstance(Dept.class);

        System.out.println(dept);

    }
}
