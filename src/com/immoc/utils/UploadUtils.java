package com.immoc.utils;

import java.util.UUID;


public class UploadUtils {
    /**
     * 生成唯一文件名
     *
     * @param fileName
     * @return String
     */
    public static String getUUIDFileName(String fileName) {
        //获取扩展名称
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-", "") + ext;
    }
}


