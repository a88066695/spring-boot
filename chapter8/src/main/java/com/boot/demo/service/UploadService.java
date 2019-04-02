package com.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);

    @Value("${upload.path}")
    private String uploadPath;

    public void uploadFile(MultipartFile...files){
        for(MultipartFile file : files){
            try {
                if(file.getResource().isFile()){
                    uploadFile(file.getInputStream(), file.getOriginalFilename());
                }
            } catch (IOException e){
                logger.error("上传失败...",e.getMessage(),e);
                throw new RuntimeException();
            }
        }

    }

    public void uploadBase64File(String baseStr){
        String[] strs = baseStr.split("base64,");
        byte[] buf = Base64Utils.decodeFromString(strs.length > 1 ? strs[1] : strs[0]);
        ByteArrayInputStream bis = new ByteArrayInputStream(buf);
        try {
            uploadFile(bis, "temp.png");
        } catch (IOException e){
            logger.error("上传失败...",e.getMessage(),e);
            throw new RuntimeException();
        }
    }

    private void uploadFile(InputStream inputStream,String name) throws IOException{
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(uploadPath + name);
        } catch (FileNotFoundException ex) {
            File file = new File(uploadPath + name);
            file.createNewFile();
            fos = new FileOutputStream(file);
        }

        try {
            FileCopyUtils.copy(inputStream,fos);
        } finally {
            inputStream.close();
            fos.flush();
            fos.close();
        }

    }
}
