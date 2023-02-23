package com.kumar.springbootaws.service.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kumar.springbootaws.exception.DBExceptionOccur;
import com.kumar.springbootaws.exception.ResourceNotFoundException;
import com.kumar.springbootaws.model.User;
import com.kumar.springbootaws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AmazonS3ServiceImpl implements AmazonS3Service {

    @Autowired
    private UserRepository userRepository;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;

    @Override
    public String upload(MultipartFile file) {
        File fileObj = convertMultiPartToFile(file);
        String fileName = System.currentTimeMillis() + "+" + fileObj.getName();
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        String url = amazonS3.getUrl(bucketName, fileName).toString();
        System.out.println(url);
        fileObj.delete();
        return url;
    }

    private File convertMultiPartToFile(MultipartFile multipartFile) {
        final File file = new File(multipartFile.getOriginalFilename());
        File fileName = new File(file.getName());
        try (final FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(multipartFile.getBytes());
            outputStream.close();
        } catch (IOException e) {
////	            log.info("Error occurred while converting the multipart file");
//	            log.error("got this: "+e.getMessage());
            System.out.println("Error occurred while converting the multipart fil");
        }
        return fileName;
    }

    @Override
    public String updateProfileImage(String userId, String imageUrl) {

        User userProfile = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
        userProfile.setProfilePictureUrl(imageUrl);
        try {
            userRepository.save(userProfile);
            return "profile image is updated";
        } catch (Exception e) {
            throw new DBExceptionOccur("Error Occurred During The Operation Save !!");
        }
    }

    @Override
    public String deleteProfileImage(String userId) {

        User userProfile = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
        userProfile.setProfilePictureUrl("");
        try {
            userRepository.save(userProfile);
            return "profile Image is removed";
        } catch (Exception e) {
            throw new DBExceptionOccur("Error Occured During The Opeartion Save !!");
        }
    }
}