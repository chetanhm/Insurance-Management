package com.im.collection;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "files")
public class FileDetails {
	private String fileName;
	private String contentType;
	private byte[] fileContent;
	@Id
	private String id;

	public FileDetails() {

	}

	public FileDetails(String fileName, String contentType, byte[] fileContent) {
		this.fileName = fileName;
		this.contentType = contentType;
		this.fileContent = fileContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", contentType=" + contentType + ", fileContent="
				+ Arrays.toString(fileContent) + "]";
	}

}
