package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.InputStream;

public class Handler implements RequestHandler<InputStream, String> {
    @Override
    public String handleRequest(InputStream inputStream, Context context) {
        String bucketName = System.getenv("S3_BUCKET_NAME");
        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        // Implement your logic to handle the incoming image upload request
        // and upload the image to the S3 bucket
        s3Client.putObject(new PutObjectRequest(bucketName, "uploaded-image.jpg", inputStream));

        return "Image uploaded successfully";
    }
}
