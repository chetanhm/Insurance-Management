package com.im.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface  FileService {
public String addFile(MultipartFile file) throws IOException ;
public ResponseEntity<?> getFile(String fileName) throws FileNotFoundException ;

}
