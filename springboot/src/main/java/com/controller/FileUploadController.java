package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {
    @RequestMapping("/fileUploadController")
    public Map FileUpload(MultipartFile filename) throws IOException {
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("d:/"+filename.getOriginalFilename()));
        Map map = new HashMap();
        map.put("msg", "ok");
        return map;
    }
}
