package com.cliffside.springboot_scaffold.config;

import com.cliffside.springboot_scaffold.listener.MyHttpSessionListener;
import com.cliffside.springboot_scaffold.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cliffside
 * @date 2021-04-29 15:48
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Bean
    public ServletListenerRegistrationBean listenerRegist(){
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new MyHttpSessionListener());
        System.out.println("listener");
        return srb;
    }
    //将自定义的servlet添加到springboot容器中,当配置了urlmappings之后，servlet自己的配置就不会生效
    @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean = new ServletRegistrationBean<>(
                new MyServlet(),"/servlet");
        myServletServletRegistrationBean.setLoadOnStartup(1);
        return myServletServletRegistrationBean;
    }

    //自定义添加视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/view").setViewName("hello");
    }
}
