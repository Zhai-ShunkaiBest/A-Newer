package top.cliffside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cliffside
 * @date 2021-05-16 16:00
 */
@RestController
public class RespController {
    @RequestMapping("/testReturnVoid")
    public String testReturnVoid() throws Exception {
        System.out.println("AccountController 的 testForward 方法执行了。。。。");
        return "我是大帅逼";
    }
}
