package com.lks.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import java.io.IOException;
import java.io.InputStream;


/**
 * 文件上传
 *
 * @author lks
 * @Time 2019/11/14
 **/
@Slf4j
@RestController(value = "/demo/file/")
public class FileController {


    @PostMapping("/fileUpload")
    public String uploadFile(@RequestParam("file")MultipartFile file) {
        try {
            if(file.isEmpty()){
                throw new ValidationException("文件不能为空");
            }
            //文件大小
            long size = file.getSize();
            //文件名稱
            String name = file.getName();
            //文件全路徑
            String originalFilename = file.getOriginalFilename();
            //文件類型
            String contentType = file.getContentType();
            //文件流
            InputStream inputStream = file.getInputStream();
            Resource resource = file.getResource();

            //數據保存到文件服務器,本地

            //數據存入數據庫
        } catch (ValidationException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
        return "success";

    }
}
