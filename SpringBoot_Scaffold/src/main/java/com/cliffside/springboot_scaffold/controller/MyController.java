package com.cliffside.springboot_scaffold.controller;

import com.cliffside.springboot_scaffold.listener.MyHttpSessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author cliffside
 * @date 2021-04-29 15:53
 */
@Controller
public class MyController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        return "hello";
    }

    @RequestMapping("online")
    @ResponseBody
    public String online(){
        return "当前在线人数："+ MyHttpSessionListener.online +"人";
    }

    @RequestMapping("hello")
    public String hello(HttpSession session){
        session.setAttribute("cliff","1111");
        return "/hello";
    }
}
