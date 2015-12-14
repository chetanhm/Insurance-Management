package com.im.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public class FileServiceImplementation implements FileService {

	public String addFile(MultipartFile file) {
		String targetName = ((int) (Math.random() * 1000)) + "_" + file.getOriginalFilename();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("uploadedFiles/" + targetName)));
				stream.write(bytes);
				stream.close();
				return "{\"fileName\": \""+targetName+"\"}";
			} catch (Exception e) {
				return "Failed";
			}
		} else {
			return "Failed";
		}
	}

	public ResponseEntity<InputStreamResource> getFile(String fileName) throws FileNotFoundException {
		   File f=new File("uploadedFiles/"+fileName);
		   FileInputStream is=new FileInputStream(f);
		   HttpHeaders headers = new HttpHeaders();
		   headers.add("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		   return ResponseEntity
		            .ok()
		            .headers(headers)
		            .contentLength(f.length())
		            .contentType(MediaType.parseMediaType("application/octet-stream"))
		            .body(new InputStreamResource(is));
	}

}
