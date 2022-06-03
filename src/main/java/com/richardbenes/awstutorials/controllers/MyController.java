package com.richardbenes.awstutorials.controllers;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

import org.springframework.beans.factory.annotation.Value;

@Controller
@Getter
@Slf4j
public class MyController {

    int number = 1;
    Instant currentTime;

    final Region region;
    final S3Client s3Client;

    public MyController(
        @Value("${aws.accessKey}") String accessKey,
        @Value("${aws.secretKey}") String secretKey
    ) {

        var awsCreds =
            StaticCredentialsProvider.create(
                AwsBasicCredentials
                    .create(accessKey, secretKey));

        region = Region.EU_CENTRAL_1;
        s3Client = 
            S3Client
                .builder()
                .credentialsProvider(awsCreds)
                .region(region)
                .build();
    }

    @GetMapping("/")
    ResponseEntity<?> home() {

        log.info("MyController.home()");

        return ResponseEntity
            .ok("Hello " + this.getNumber() + " at " + Instant.now());
    }

    @GetMapping("/bucket/{bucketName}")
    ResponseEntity<?> getBucketKeys(
        @PathVariable("bucketName") String bucketName
    ) {

        ListObjectsRequest listObjectsRequest =
            ListObjectsRequest
                .builder()
                .bucket(bucketName)
                .build();
        
        var objects = 
            s3Client.listObjects(listObjectsRequest).contents()
            .stream()
            .map(s3Object -> s3Object.key());

        return ResponseEntity.ok().body(objects);
    }
}
