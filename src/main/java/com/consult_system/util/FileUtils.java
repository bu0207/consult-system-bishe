package com.consult_system.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @descreption 文件上传工具类
 */
public class FileUtils {
    public static String upload(MultipartFile file,String path,String fileName){
        // 生成新的文件名
        String realPath = path + "/" + FileNameUtils.getFileName(fileName);
        String fileNameNew = FileNameUtils.getFileName(fileName);
        File dest = new File(new File(path).getAbsolutePath() + "/" + fileNameNew);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return fileNameNew;
        }catch (IllegalStateException e){
            e.printStackTrace();
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
