package com.im.service;

import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface  FileService {
public String addFile(MultipartFile file);
public ResponseEntity<InputStreamResource> getFile(String fileName) throws FileNotFoundException ;

}

