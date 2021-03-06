package com.im.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/file", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE, consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
	public @ResponseBody String addFile(@RequestParam("file") MultipartFile file) throws IOException {

		return fileService.addFile(file);

	}

	@RequestMapping(value = "/file/{fileName}", method = RequestMethod.GET)
	public ResponseEntity<?> getFile(@PathVariable("fileName") String fileName) throws IOException {
		return fileService.getFile(fileName);
	}
}
