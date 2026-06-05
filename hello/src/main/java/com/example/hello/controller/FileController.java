package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class FileController {
    
    @GetMapping("/upload-file")
    public String upload() {
        return "uploadFile";
    }
    
    @PostMapping("/upload-file")
    public String upload(@RequestParam(name = "file") MultipartFile file) {
        
        System.out.println("####: " + file.getOriginalFilename());
        return "uploadFile";
    }
    
}
