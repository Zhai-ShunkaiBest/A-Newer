package top.cliffside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cliffside
 * @date 2021-05-16 19:36
 */
@Controller
public class FirstController {
    @RequestMapping("/firstController")
    @ResponseBody
    public String firstController(){
        return "hello springboot";
    }
}
