package com.zfk.ssms.controller;

import com.zfk.ssms.common.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ZFK
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/pic")
    public Result upload(@RequestBody MultipartFile file) throws IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 设置文件保存路径
        String filePath = "F:\\IdeaProjects\\ssms\\src\\main\\resources\\static\\image\\";
        // 创建保存文件的目录
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        // 将文件保存到本地
        file.transferTo(dest);
        // 返回保存结果
        return Result.success(null, "上传成功");
    }
}
