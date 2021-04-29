package com.cliffside.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cliffside
 * @date 2021-04-29 21:53
 * 需求:记录每次请求中如下的信息并存储进入日志文件
 *
 * 请求的来源
 *
 * 浏览器所在电脑IP
 *
 * 请求的资源 URL
 *
 * 请求发生的时间
 */
@WebListener
public class LogDemo  implements ServletRequestListener {
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 获得请求发出的IP
        // 获得请求的URL
        // 获得请求产生的时间
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String remoteHost = request.getRemoteHost();
        String requestURL = request.getRequestURL().toString();
        String reqquestDate = simpleDateFormat.format(new Date());
        // 准备输出流
        try {
            PrintWriter pw =new PrintWriter(new FileOutputStream(new File("c:/log.txt"),true));
            pw.println(remoteHost+" "+requestURL+" "+reqquestDate );
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
