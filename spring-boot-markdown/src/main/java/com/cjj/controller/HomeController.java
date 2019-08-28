package com.cjj.controller;

import com.cjj.model.Blog;
import com.cjj.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/28 16:57
 */
@Controller
public class HomeController {
    private static String UPLOADED_FOLDER = "F://";
    @Autowired
    BlogRepository blogRepository;

    @RequestMapping("/edit")
    public String editor(){
        return "edit";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/submit")
    @ResponseBody
    public void submit(Blog blog){
        System.out.println(blog.getContent());
        System.out.println(blog.getHtmlContent());
        blogRepository.save(blog);
    }

    @RequestMapping("/wxcontent")
    @ResponseBody
    public Blog wxcontent(){
        Blog blog =  blogRepository.findBlogById(2l);
        System.out.println(blog.getHtmlContent());
        return  blog;
    }
    //处理文件上传
    @RequestMapping(value="/uploadimg")
    public @ResponseBody Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        String realPath = UPLOADED_FOLDER;
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
/*        File targetFile = new File(realPath, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }*/
        //保存
        try {
            /*            file.transferTo(targetFile);*/
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url",UPLOADED_FOLDER+fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        System.out.println(resultMap.get("success"));
        return resultMap;
    }
}
