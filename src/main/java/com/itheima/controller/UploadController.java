package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;

@Slf4j
@RestController

public class UploadController {
    //本次存储
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException
//    {
//        log.info("文件上传：{},{},{}",username,age,image);
//
//        String originalFilename = image.getOriginalFilename();
//        //将文件存储在服务器的磁盘目录
//        image.transferTo(new File("E:/images/"+originalFilename));
//        return Result.success();
//    }
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException
    {
        log.info("文件上传，文件名：{}",image.getOriginalFilename());
        String url= aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问url:{}",url);
        return Result.success(url);
    }
}
