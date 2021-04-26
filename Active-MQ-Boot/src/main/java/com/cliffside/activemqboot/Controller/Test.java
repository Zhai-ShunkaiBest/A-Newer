package com.cliffside.activemqboot.Controller;

import com.cliffside.activemqboot.Service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cliffside
 * @date 2021-04-21 11:01
 */
@RestController
public class Test {
    @Autowired
    SenderService senderService;
    @RequestMapping("send")
    public String send(){
        senderService.send("springboot","hello");
        return "ok";

    }
}
