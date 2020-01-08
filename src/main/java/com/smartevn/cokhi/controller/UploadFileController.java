package com.smartevn.cokhi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartevn.cokhi.model.ApiResp;

/**
 * 
 * @author vadinh
 *
 */
@RestController
@RequestMapping("/api")
public class UploadFileController {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);
    
    private final String UPLOAD_FOLDER = "D:\\tools\\apache-tomcat-8.5.46\\webapps\\ROOT\\assets\\images\\cokhi\\";
    private final String IMG_PATH = "http://localhost:8080/assets/images/cokhi/";
    
    private String uploadPath = "";
    private String imgPath = "";
    @PostMapping("/upload")
    public ResponseEntity<ApiResp> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info("==============================POST upload file==================");
        logger.info(this.uploadPath + "====================" + this.imgPath);
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size = file.getSize();
        
        readConfiguration();
        // write file to the path ex: D:/
        byte[] bytes = file.getBytes();
        Path path = Paths.get(this.uploadPath + file.getOriginalFilename());
        Files.write(path, bytes);
        
        logger.info("inputStream: " + inputStream);
        logger.info("originalName: " + originalName);
        logger.info("name: " + name);
        logger.info("contentType: " + contentType);
        logger.info("size: " + size);
        // Do processing with uploaded file data in Service layer
        ApiResp body = new ApiResp();
        body.setData(this.imgPath + originalName);
        
        return new ResponseEntity<ApiResp>(body, HttpStatus.OK);
    }
    
    public void readConfiguration() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("cokhiconfig.txt"))) {
            // read line by line
            String line;
            this.uploadPath = br.readLine().replace("\\", "/");
            System.out.println("UploadFileController.readConfiguration()==========path: " + this.uploadPath);
            this.imgPath = br.readLine().replace("\\", "/");;
            int i = 0;
            while ((line = br.readLine()) != null) {
//                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        logger.info(this.uploadPath + "====================" + this.imgPath);
        System.out.println("UploadFileController.readConfiguration()" + this.uploadPath + "====================" + this.imgPath);
    }
}
