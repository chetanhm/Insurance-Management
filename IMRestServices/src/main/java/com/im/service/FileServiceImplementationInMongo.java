package com.im.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.im.collection.FileDetails;
import com.im.repository.FileRepository;

@Service
public class FileServiceImplementationInMongo implements FileService {
	@Autowired
	FileRepository fileRepository;
	public String addFile(MultipartFile file) throws IOException {
		
		FileDetails fileDetails=new FileDetails(file.getOriginalFilename(), file.getContentType(), file.getBytes());
		fileRepository.insert(fileDetails);
		
		
		return "{\"fileName\": \""+fileDetails.getId()+"\"}";
	
	}

	public ResponseEntity<byte[]> getFile(String fileName) throws FileNotFoundException {
		 HttpHeaders headers = new HttpHeaders();
		 FileDetails fileDetails=fileRepository.findOne(fileName);
		headers.add("Content-Disposition", "attachment; filename=\""+fileDetails.getFileName()+"\"");
		   return ResponseEntity
		            .ok()
		            .headers(headers)
		            .contentLength(fileDetails.getFileContent().length)
		            .contentType(MediaType.parseMediaType(fileDetails.getContentType()))
		            .body(fileDetails.getFileContent());
	}

}
