package com.vs.Syntoy.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;

@Component
public class S3Utility {
	
	@Value("${aws.s3bucket}")
	private String s3BucketName; 
	
	@Autowired
	private AmazonS3 s3Client;
	
	public String validateS3Link(String episodeS3Link) {
		try {
			s3Client.getObjectMetadata(s3BucketName, episodeS3Link);
			String url = s3Client.getUrl(s3BucketName, episodeS3Link).toString();
			System.out.println(url);
			
			return url;
		}
		catch(AmazonServiceException e){
			System.out.println(e.getErrorMessage());
			return "";
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
	

	public Boolean getEpisodeFromS3(String episodeS3Link){
		try {
			s3Client.getObject(s3BucketName, episodeS3Link);
			return true;
		}
		catch(AmazonServiceException e){
			System.out.println(e.getErrorMessage());
			return false;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
