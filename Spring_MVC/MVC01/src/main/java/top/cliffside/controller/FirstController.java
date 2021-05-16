package top.cliffside.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author cliffside
 * @date 2021-05-16 13:00
 * 1@RequestMapping控制请求方式
 * method属性可以控制请求的方式,值为RequestMethod的枚举值
 *
 * 2@RequestMapping控制请求参数params和请求头headers
 * param:表示请求中必须包含名为param的参数
 * !param:表示请求中不能包含名为param的参数
 * param  = value 表示请求中包含名为param的参数,但是值必须是value
 * param != value 表示请求中包含名为param的参数,但是值不能是value
 * {"param1","param2=value"},可以将对于多个参数的要求写入数组
 *
 * 3@PathVariable注解和RESTful风格的支持
 * 普通形式的url
 *      ***** /contextPath/aaa.do
        ****** /contextPath/aaa.jsp
        ****** /contextPath/aaa.html
        ****** /contextPath/css/aaa.css
        ****** /contextPath/js/aaa.js
        ****** /contextPath/aaa.do?id=10&username=root
        *restFul风格的url
        ****** /contextPath/aaa/10/root
        ****** /contextPath/aaa
 *
 *
 * Http协议中,四个表示操作方式的动词"GET POST PUT DELETE",他们对应四种基本操作,GET用来获取资源,POST用来新建资源,PUT用来更新资源,DELETE用来删除资源
 *
 * 简单的说,就是我们在访问资源时,可以通过这四个状态来表示对于资源的不同操作,这四个状态表现为我们请求的四种方式
 * /controller/1  HTTP GET :得到id为1 的资源
 * /controller/1  HTTP DELETE :删除id为1的资源
 * /controller/1  HTTP PUT :更新id为1 的资源
 * /controller/1  HTTP POST :增加id为1 的资源
 *
 * 在访问同一个url的时候,通过不同的请求方式,对应到不同的controller处理单元
 */
@Controller
@RequestMapping("/cliffside")
public class FirstController {

    private static final Logger logger = LogManager.getLogger(FirstController.class);
    @RequestMapping("/controller1.action")
    public String firstController(){

        logger.info("正在测试controller");
        return "first";
    }

    @RequestMapping("/testPathVariable/{id}/{username}")
    public String testPathVariable(@PathVariable("id") Integer id, @PathVariable("username")String name){
        logger.info("正在测试controllerRest");
        logger.info(id+":"+name);
        return "success";
    }

    @ExceptionHandler(value ={ArithmeticException.class,NullPointerException.class} )
    public ModelAndView handelException(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("error1.jsp");
        return mv;
    }
}
