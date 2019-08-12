package com.glodon.springboothello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangbh
 * @Date: 2019/8/8 15:54
 * @Description:
 */
@RestController
public class UploadController {
    Map<String, Object> result = new HashMap<>();

    @RequestMapping("/uploadfile")
    public Map<String, Object> uploadFile(@RequestParam("attach") MultipartFile file) throws IOException {
        System.out.println("文件原名" + file.getOriginalFilename());
        file.transferTo(new File("E:/Temp/" + file.getOriginalFilename()));
        result.put("success", true);
        return result;

    }
}
