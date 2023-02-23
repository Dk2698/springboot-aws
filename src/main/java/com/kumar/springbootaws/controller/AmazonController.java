package com.kumar.springbootaws.controller;

import com.kumar.springbootaws.service.s3.AmazonS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/image")
public class AmazonController {

    @Autowired()
    private AmazonS3Service service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.upload(file), HttpStatus.OK);
    }

    @GetMapping("/updateProfileImage")
    public String updateImageProfile(@RequestParam String userId, @RequestParam String imageUrl) {
        return service.updateProfileImage(userId, imageUrl);
    }

    @GetMapping("/deleteProfileImage")
    public String updateImageProfile(@RequestParam String userId) {
        return service.deleteProfileImage(userId);
    }

}