import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cliffside
 * @date 2021-05-05 14:38
 * 单线程 不加sync
 * 多线程 加锁sync
 * 自旋锁 用自己的mysafe
 * concurrentHashMap
 *
 */
public class MybatisEnhance {

    private static int size = 10000000;
    private static Map<Class<?>,Object> objectMap = new HashMap<>(size);
    @Data
    static class MapperScanner{
        private String mapperLocation;

        public List<Class<?>> scanMapper(){
            List<Class<?>> objects = Lists.newArrayList();
            for (int i = 0; i < size; i++) {
                objects.add(MybatisEnhance.class);
            }
            return objects;
        }
    }

    public static synchronized void put(Class<?> clazz,Object o){
        objectMap.put(clazz,o);
    }
    public static void main(String[] args) {
        String mapperLocation = "classpath:mapper/*.xml";
        MapperScanner mapperScanner = new MapperScanner();
        mapperScanner.setMapperLocation(mapperLocation);


        List<Class<?>> classes = mapperScanner.scanMapper();

        long start = System.currentTimeMillis();
        classes.parallelStream().forEach(clazz -> put(clazz,new Object()));
//        classes.forEach(clazz -> put(clazz,new Object()));

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
