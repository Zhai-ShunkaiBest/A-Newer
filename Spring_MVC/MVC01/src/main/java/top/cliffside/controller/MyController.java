package top.cliffside.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cliffside
 * @date 2021-05-16 14:57
 */
@RestController
@RequestMapping(value = "/myController")
public class MyController {
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testPut(@PathVariable(value = "id") Integer id){
        System.out.println("testPut, id:"+id);
        return "success";
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testDelete(@PathVariable(value = "id") Integer id){
        System.out.println("testDelete, id:"+id);
        return "success";
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.POST)
    public String testPOST(@PathVariable(value = "id") Integer id){
        System.out.println("testPOST, id:"+id);
        return "show";
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testGET(@PathVariable(value = "id") Integer id){
        System.out.println("testGET, id:"+id);
        return "show";
    }
}