package com.smartevn.cokhi.controller;

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

/**
 * 
 * @author vadinh
 *
 */
@RestController
@RequestMapping("/api")
public class UploadFileController {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @GetMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info("==============================GET upload file==================");
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size = file.getSize();
        logger.info("inputStream: " + inputStream);
        logger.info("originalName: " + originalName);
        logger.info("name: " + name);
        logger.info("contentType: " + contentType);
        logger.info("size: " + size);
        // Do processing with uploaded file data in Service layer
        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info("==============================POST upload file==================");
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size = file.getSize();
        
        // write file to the path ex: D:/
        byte[] bytes = file.getBytes();
        Path path = Paths.get("D:/" + file.getOriginalFilename());
        Files.write(path, bytes);
        
        logger.info("inputStream: " + inputStream);
        logger.info("originalName: " + originalName);
        logger.info("name: " + name);
        logger.info("contentType: " + contentType);
        logger.info("size: " + size);
        // Do processing with uploaded file data in Service layer
        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }
}
