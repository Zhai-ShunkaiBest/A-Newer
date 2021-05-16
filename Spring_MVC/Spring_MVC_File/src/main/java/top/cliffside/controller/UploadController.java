package top.cliffside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author cliffside
 * @date 2021-05-16 17:06
 */
@Controller
public class UploadController {
    @RequestMapping("fileup.action")
    @ResponseBody
    public String fileUpload(MultipartFile photo) throws IOException {
        // 指定文件存储目录
        File dir = new File("d:/imgs");
        String originalFilename = photo.getOriginalFilename();
        // 文件存储位置
        File file =new File(dir,originalFilename);
        //  文件保存
        photo.transferTo(file);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public String fileUpload2(MultipartFile headPhoto, HttpServletRequest req) throws IOException {
        // 指定文件存储目录为我们项目部署环境下的upload目录
        String realPath = req.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        // 如果不存在则创建目录
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 获取文件名
        String originalFilename = headPhoto.getOriginalFilename();
        // 文件存储位置
        File file =new File(dir,originalFilename);
        //  文件保存
        headPhoto.transferTo(file);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public String fileUpload3(MultipartFile headPhoto, HttpServletRequest req) throws IOException {
        // 指定文件存储目录为我们项目部署环境下的upload目录
        String realPath = req.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        // 如果不存在则创建目录
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 获取文件名
        String originalFilename = headPhoto.getOriginalFilename();
        // 避免文件名冲突,使用UUID替换文件名
        String uuid = UUID.randomUUID().toString();
        // 获取拓展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 新的文件名
        String newFileName=uuid.concat(extendsName);
        // 文件存储位置
        File file =new File(dir,newFileName);
        //  文件保存
        headPhoto.transferTo(file);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public Map<String,String> fileUpload(MultipartFile headPhoto, HttpServletRequest req) throws IOException {
        Map<String,String> map=new HashMap<>();
        // 控制文件大小
        if(headPhoto.getSize()>1024*1024*5){
            map.put("message", "文件大小不能超过5M");
            return map;
        }
        // 指定文件存储目录为我们项目部署环境下的upload目录
        String realPath = req.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        // 如果不存在则创建目录
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 获取文件名
        String originalFilename = headPhoto.getOriginalFilename();
        // 避免文件名冲突,使用UUID替换文件名
        String uuid = UUID.randomUUID().toString();
        // 获取拓展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //  控制文件类型
        if(!extendsName.equals(".jpg")){
            map.put("message", "文件类型必须是.jpg");
            return map;
        }
        // 新的文件名
        String newFileName=uuid.concat(extendsName);
        // 文件存储位置
        File file =new File(dir,newFileName);
        //  文件保存
        headPhoto.transferTo(file);
        // 上传成功之后,把文件的名字和文件的类型返回给浏览器
        map.put("message", "上传成功");
        map.put("newFileName", newFileName);
        map.put("filetype", headPhoto.getContentType());
        return map;
    }
}
