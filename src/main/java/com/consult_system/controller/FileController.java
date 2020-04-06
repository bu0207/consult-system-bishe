package com.consult_system.controller;


import com.consult_system.service.ImageService;
import com.consult_system.util.FileUtils;
import com.consult_system.viewmodel.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 文件上传
 */
@RestController
public class FileController {

    private final static Logger Log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private ImageService imageService;

    private static String UPLOAD_PATH = "/root/File/";
//    private static String UPLOAD_PATH = "E:/File/";

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public ApiResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        try{

            String realPath = request.getSession().getServletContext().getRealPath("/File");
            String fileName=file.getOriginalFilename();
            String fileNameNew = FileUtils.upload(file, UPLOAD_PATH, fileName);
            if (fileNameNew!=null){

                String requestURL = request.getRequestURL().toString();
                Log.info("requestURL:<<<" + requestURL);
                String requestURI = request.getRequestURI();
                Log.info("requestURI:<<<" + requestURI);
                String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
                Log.info("url <<<<" + url);
                url=url + fileNameNew;
                Log.info("img url is<<<<:"+url);
                if (imageService.saveImage(url)){
                    return ApiResult.ok(url);
                } else{
                    return ApiResult.error("上传失败");
                }
            }else {
                return ApiResult.error("上传失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ApiResult.ok();
    }
}
