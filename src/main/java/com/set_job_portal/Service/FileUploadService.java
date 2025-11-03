package com.set_job_portal.Service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@Service
public class FileUploadService 
{
	@Autowired
	private Cloudinary cloudinary;
	
	public FileUploadService(
			@Value("${cloudinary.cloud-name}") String cloudName,
			@Value("${cloudinary.api-key}") String apiKey,
			@Value("${cloudinary.api-secret}") String apiSecret){
				this.cloudinary=new Cloudinary(ObjectUtils.asMap("cloud-name", cloudName,
						"api-key",apiKey,
						"api-secret",apiSecret));
			}
	
	public String uploadFile(MultipartFile file,String folder) throws IOException
	{
		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder",folder));
		return (String) uploadResult.get("Secure Url");
		
	}
			

}
