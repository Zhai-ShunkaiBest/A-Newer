package com.cliffside.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author cliffside
 * @date 2021-04-30 12:03
 */
public class SqlSessionUtil {
    private static final  SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    private static InputStream resourceAsStream = null;
    static {

        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(boolean b) {
        SqlSessionFactory build =sqlSessionFactoryBuilder.build(resourceAsStream);
        return build.openSession(b);
    }
}
