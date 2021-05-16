package top.cliffside.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import top.cliffside.pojo.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author cliffside
 * @date 2021-05-16 15:09
 */
@Controller
public class TestDataController {
    /** 紧耦合方式参数注入
     * 使用传统的HttpServletRequest对象获取参数  javax.servlet
     * */
    @RequestMapping("/getParamByRequest.do")
    public String getParam1(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username+"   password:"+password);
        return "getParamSuccess";
    }
    /** 解耦合方式参数注入
     * HttpServletRequest对象获取参数 通过SpringMVC框架功能,自动转换参数
     * 处理单元参数列表中参数名必须和请求中的参数名一致
     * 如不一致,可以通过@RequestParma注解进行转换
     * */
    @RequestMapping("/getParamByArgName.do")

    public String getParam2(String username,@RequestParam("pwd") int password){
        System.out.println("username:"+username+"   password:"+password);
        return "getParamSuccess";
    }


    /**
     * 使用POJO接收参数时,注意事项
     * 提交的参数名必须和POJO的属性名保持一致
     * springmvc底层通过反射给参数列表的属性赋值
     * 通过set方法设置属性值的,不是直接通过操作属性
     * POJO的属性一定要有set方法,要不然就会接收失败
     * */
//    @RequestMapping("/getDataByPojo")
//    @ResponseBody
////    public String getDataByPojo(Person p){
////        System.out.println(p);
////        return "success";
////    }

    @RequestMapping("/getData")
    public String testDataByPojo(@DateTimeFormat(pattern = "yyyy-mm-dd")Date birthday){
        System.out.println();
        return "success";
    }

    @RequestMapping("/getDataByPojo")
    public String getDataByPojo2(Person p){
        System.out.println(p);
        System.out.println(p.getPets());
        return "redirect:/success";
    }
    @RequestMapping("demo4")
    public View testDemo4(HttpServletRequest req)   {
        View  view =null;
        // 请求转发
        //view =new InternalResourceView("/forwardPage.jsp");
        // 重定向
        view=new RedirectView(req.getContextPath()+"/redirectPage.jsp");
        return view;
    }
    @RequestMapping("demo5")
    public ModelAndView testDemo5(HttpServletRequest req)   {
        ModelAndView mv=new ModelAndView();
        // 请求转发
        //mv.setViewName("forward:/forwardPage.jsp");
        //mv.setView(new InternalResourceView("/forwardPage.jsp"));
        // 重定向
        //mv.setViewName("redirect:/redirectPage.jsp");
        mv.setView(new RedirectView(req.getContextPath()+"/redirectPage.jsp"));
        return mv;
    }

}
