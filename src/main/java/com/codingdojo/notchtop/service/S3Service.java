package com.codingdojo.notchtop.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;

@Service
public class S3Service{
	
	@Value("${bucketName}")
	private String bucketName;
	
	private final AmazonS3 s3;
	public S3Service(AmazonS3 s3) {
		this.s3 = s3;
	}
	
	public String saveFile(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		try {
			File new_file = convertMultiPartFileToFile(file);
			File resizedFfileFile = resizingImage(new_file, originalFilename, 2560, 1440);
			PutObjectResult putObjectResult = s3.putObject(bucketName, originalFilename, resizedFfileFile);
			return putObjectResult.getContentMd5();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public byte[] downloadFile(String fileName) {
		S3Object object = s3.getObject(bucketName, fileName);
		S3ObjectInputStream objectContent = object.getObjectContent();
		try {
			return IOUtils.toByteArray(objectContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String deleteFile(String fileName) {
		s3.deleteObject(bucketName, fileName);
		return "File Deleted";
	}

	public List<String> listAllFiles() {
		ListObjectsV2Result listObjectsV2Result = s3.listObjectsV2(bucketName);
		return listObjectsV2Result.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
	}
	
	private File convertMultiPartFileToFile(MultipartFile file) throws IOException
	{
		File convertedFile = new File(file.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		return convertedFile;
	}
	
	private File resizingImage(File originalImage, String originalFilename , int width, int height){
        try{
        	File resizedImage = new File(originalFilename);
            BufferedImage original = ImageIO.read(originalImage);
            BufferedImage resized = new BufferedImage(width, height, original.getType());
            Graphics2D g2 = resized.createGraphics();
            g2.drawImage(original, 0, 0, width, height, null);
            g2.dispose();
        	ImageIO.write(resized, "JPG", resizedImage);
        	return resizedImage;
        }
        catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
