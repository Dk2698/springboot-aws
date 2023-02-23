package com.kumar.springbootaws.service.s3;

import org.springframework.web.multipart.MultipartFile;



  public   interface AmazonS3Service {
        String upload(MultipartFile file);

        String updateProfileImage(String userId, String imageUrl);

        String deleteProfileImage(String userId);

    }
