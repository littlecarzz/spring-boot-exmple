package com.cjj.controller;

import com.cjj.model.Blog;
import com.cjj.repository.BlogRepository;
import com.cjj.utils.FileNameUtils;
import com.cjj.utils.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private static String UPLOADED_FOLDER="f://spring-boot//spring-boot-markdown/";
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
    public Blog submit(Blog blog){
        System.out.println(blog.toString());
        Blog save = blogRepository.save(blog);
        return save;
    }

    @RequestMapping("/view")
    public String view(Long id, ModelMap map){
        Blog blog =  blogRepository.findBlogById(id);
        map.addAttribute("blog", blog);
        return "view";
    }
    @RequestMapping("/getPicture")
    public void getPicture(String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            fileName=UPLOADED_FOLDER+fileName;
            ImgUtil imgUtil = new ImgUtil();
            imgUtil.queryPic(fileName,request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //处理文件上传
    @RequestMapping(value="/uploadimg")
    public @ResponseBody Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        String realPath = UPLOADED_FOLDER;
        String fileName = file.getOriginalFilename();
        fileName = FileNameUtils.getFileName(fileName);
        //保存
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + fileName);
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url","/getPicture?fileName="+fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        return resultMap;
    }
}
