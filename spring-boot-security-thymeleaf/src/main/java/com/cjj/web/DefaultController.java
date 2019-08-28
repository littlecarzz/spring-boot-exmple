package com.cjj.web;

import com.cjj.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/28 10:17
 */
@Controller
public class DefaultController {
    @RequestMapping("/")
    public String index() {
        return "/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @RequestMapping("/user")
    public String user() {
        return "/user";
    }

    @RequestMapping("/about")
    public String about() {
        return "/about";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/403")
    public String error403() {
        return "/error/403";
    }

/*    @RequestMapping("/logout")
    public String logout() {
        return "/login";
    }*/
    @RequestMapping("qrcode")
    public String qrcode() {
        return "/qrcode";
    }

    @RequestMapping(value="/qrimage")
    public ResponseEntity<byte[]> getQRImage() {

        //二维码内的信息
        String info = "This is my first QR Code";

        byte[] qrcode = null;
        try {
            qrcode = QRCodeGenerator.getQRCodeImage(info, 360, 360);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {

            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);
    }
}
