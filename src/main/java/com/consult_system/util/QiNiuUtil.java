package com.consult_system.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.UUID;

public class QiNiuUtil {

    /**
     * 上传
     * @param
     */
    public static void main(String[] args) {
        //Zone0() 代表华东地区
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);

        //AccessKey的值
        String accessKey = "Bc0FB3pe4G824T2laiK3NuKxOFpksy_FT49Q9q2S";
        //SecretKey的值
        String secretKey = "AXbH_gpKJCaRy3EqcxV8fMeXA1dhXmT-glEs_9xT";
        //存储空间名
        String bucket = "bu-bishe";
        //上传图片路径
        String localFilePath = "G:\\qiniutest\\zhengjianzhao.JPG";

        File file1 = new File(localFilePath);
        //在七牛云中图片的命名
        String key = UUID.randomUUID().toString().replace("-","");
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);

            Response response1 = uploadManager.put(file1,key,upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response1.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            System.out.println("外链:" +  "http://q5squ0ytw.bkt.clouddn.com/" + key);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        deleteFile(key);
    }

    public static void deleteFile(String key) {
        //AccessKey的值
        String accessKey = "Bc0FB3pe4G824T2laiK3NuKxOFpksy_FT49Q9q2S";
        //SecretKey的值
        String secretKey = "AXbH_gpKJCaRy3EqcxV8fMeXA1dhXmT-glEs_9xT";
        String bucket = "bu-bishe";
        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(accessKey, secretKey);
        try {
            BucketManager bucketManager = new BucketManager(auth,cfg);
            bucketManager.delete(bucket,"246729e72f5b469596493233cdffcbe0");
        }catch (QiniuException ex){
            Response r = ex.response;
            System.err.println(r.toString());
        }
    }

    /**
     * multipartFile转file
     * @param multipartFile
     * @return
     */
    public File multipartToFile(MultipartFile multipartFile){
        File file = null;
        if (multipartFile.equals("") || multipartFile.getSize() <= 0) {
            file = null;
        } else {
            CommonsMultipartFile cf = (CommonsMultipartFile)multipartFile;
            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
            file = fi.getStoreLocation();
        }
        return file;
    }
}
