package com.simplilearn.AwsJava;

import java.io.File;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class App {
	public static void main(String[] args) {
//		AWSCredentials credentials = new BasicAWSCredentials("ASIATO4JCCTL3CC2ZIO6",
//				"L+AasC9A3m4Zwj8q/iv+tk1EAQXLiORZNnl8MWcE");

		AWSCredentials credentials = new BasicAWSCredentials("AKIATO4JCCTL5G4APO4K",
				"fw80FBiNPcE1bz409ugIOeWgyM/P4r5ENHxMb3bg");

		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();

		String bucketName = "yokekhei123bucket";
		if (s3client.doesBucketExist(bucketName)) {
			System.out.println("Bucket exists");
			return;
		}

		s3client.createBucket(bucketName);
		System.out.println("Bucket created");

		List<Bucket> buckets = s3client.listBuckets();
		for (Bucket bucket : buckets) {
			System.out.println(bucket.getName());
		}
		
		s3client.putObject("yokekhei123bucket", "sample-1", new File("sample.txt"));
	}

}
