package com.im.utils;


import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import com.google.gson.Gson;
import com.im.entity.ImgUploadOss;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaojinhui
 * @date 2021/2/19 17:26
 * @apiNote
 */
public class ImgUploadUtil {

    public static ImgUploadOss imgUpload(byte[] data, String fileName){
        String body = HttpRequest.post("https://imgurl.org/upload/ftp")
                .contentType(ContentType.MULTIPART.toString())
                .form("file", data,fileName)
                .execute()
                .body();
        Gson gson = new Gson();
        return gson.fromJson(body, ImgUploadOss.class);
    }

    public static ImgUploadOss imgUpload(File file){
        String body = HttpRequest.post("https://imgurl.org/upload/ftp")
                .contentType(ContentType.MULTIPART.toString())
                .form("file", file)
                .execute()
                .body();
        Gson gson = new Gson();
        return gson.fromJson(body, ImgUploadOss.class);
    }

    public static ImgUploadOss imgUpload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        File tempFile = new File("temp.png");
        FileUtils.copyInputStreamToFile(inputStream, tempFile);
        String body = HttpRequest.post("https://imgurl.org/upload/ftp")
                .contentType(ContentType.MULTIPART.toString())
                .form("file", tempFile)
                .execute()
                .body();
        Gson gson = new Gson();
        return gson.fromJson(body, ImgUploadOss.class);

    }

}
