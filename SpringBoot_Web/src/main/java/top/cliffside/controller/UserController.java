package top.cliffside.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cliffside.pojo.User;
import top.cliffside.service.UserService;

import java.util.List;

/**
 * @author cliffside
 * @date 2021-05-16 20:42
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        Log log = LogFactory.getLog(UserController.class);
        log.info("正在测试controller");
        return userService.findAll();
    }

}