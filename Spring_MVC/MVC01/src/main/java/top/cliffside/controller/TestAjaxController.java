package top.cliffside.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cliffside.pojo.Person;
import top.cliffside.pojo.Pet;

/**
 * @author cliffside
 * @date 2021-05-16 16:13
 */
@Controller
public class TestAjaxController {
    /**
     * @ResponseBody
     * 1方法的返回值不在作为界面跳转依据,而已直接作为返回的数据
     * 2将方法的返回的数据自动使用ObjectMapper转换为JSON
     */
    @ResponseBody
    @RequestMapping("testAjax")
    public Person testAjax(Person p) throws JsonProcessingException {
        System.out.println(p);

        return p;
    }
}
