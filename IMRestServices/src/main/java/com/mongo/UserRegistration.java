package com.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user_registrations")
public class UserRegistration {

	@Id
	private String id;
	private String userName;
	private String emailId;
	private String password;

	public UserRegistration(String userName, String emailId, String password) {
		this.userName = userName;
		this.emailId = emailId;;
		this.password = password;
	}

	public UserRegistration() {
		
	}
	public String getUserName() {
		return userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", userName=" + userName
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
	
}
