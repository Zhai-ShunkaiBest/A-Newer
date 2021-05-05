import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cliffside
 * @date 2021-05-05 14:55
 */
public class MyUnsafe {
    // setup to use Unsafe.compareAndSwapInt for updates
//    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final Unsafe unsafe;
    private static final long valueOffset;

    static {
        try {
            Class<Unsafe> unsafeClass = Unsafe.class;
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe)theUnsafe.get(null);
            valueOffset = unsafe.objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int value = 0;

    public void CASLock(){
        while (true){
            if (unsafe.compareAndSwapInt(this,value,0,1)){
                return;
            };
            Thread.currentThread().yield();
        }
    }

    public void CASUnlock(){
        value = 0;
    }
    public static void main(String[] args) {
        System.out.println(unsafe);
    }

}
