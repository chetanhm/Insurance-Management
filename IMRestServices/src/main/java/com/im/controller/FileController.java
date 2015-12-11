package com.im.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.im.service.FileService;

@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/addFile", method = RequestMethod.POST)
	public @ResponseBody String addFile(@RequestParam("file") MultipartFile file) {

		return fileService.addFile(file);

	}
	

	@RequestMapping(value = "/getFile", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getFile(@RequestParam("fileName") String fileName) throws IOException {
		return fileService.getFile(fileName);
	}
}
