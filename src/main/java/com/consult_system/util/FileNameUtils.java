package com.consult_system.util;

public class FileNameUtils {

    /**
     * 获取文件后缀
     * @param filename
     * @return
     */
    public static String getSuffix(String filename){
        return filename.substring(filename.lastIndexOf("."));
    }

    /**
     *生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }
}
