package com.im.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class FileController {
	@RequestMapping(value = "/addFile", method = RequestMethod.POST)
	public @ResponseBody String addFile(@RequestParam("file") MultipartFile file) {
		String fileExtension = file.getContentType();

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
	
	
	@RequestMapping(value="/getFile",method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getFile(@RequestParam("fileName") String fileName) throws IOException
	{
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
