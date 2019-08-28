package com.cjj.web;

import com.cjj.utils.ImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/26 16:50
 */
@Controller
public class UploadController {
    /**
     * 文件接收地址
     */
    private static String UPLOADED_FOLDER = "f://spring-boot//spring-boot-file-upload//";
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam(value = "file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("fileUrl",
                    path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    @PostMapping("/view")
    public String view(@RequestParam("fileUrl") String fileUrl, ModelMap map) {
        map.addAttribute("fileUrl", fileUrl);
        return "view";
    }

    @RequestMapping("/getPicture")
    public void getPicture(String filename, HttpServletRequest request, HttpServletResponse response) {
        try {
            new ImgUtil().queryPic(filename,request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
