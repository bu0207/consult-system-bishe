package com.consult_system.controller;

import com.consult_system.util.QiNiuUtil;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class QiNiuController {

    @RequestMapping(value = "/qiniu/upload",method = RequestMethod.POST)
    public ApiResult QiNiuUpload(HttpServletRequest request,@RequestParam("imageFile") MultipartFile multipartFile){

        QiNiuUtil qiNiuUtil =new QiNiuUtil();
            //文件扩展名
            String filenameExtension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."), multipartFile.getOriginalFilename().length());
            //MultipartFile 转 file 类型
            File file = qiNiuUtil.multipartToFile(multipartFile);
        return ApiResult.ok();
    }
}
