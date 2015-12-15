package com.im.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userdetails")
public class UserDetails {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String city;
	private String contactNo;
	private String email;
	private String userName;
	private String password;
	private String loginStatus;
	private String userType;
	private String agentName;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String fastName) {
		this.lastName = fastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contact_no) {
		this.contactNo = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails(String firstName, String fastName, String address,
			String state, String city, String contact_no, String email,
			String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = fastName;
		this.address = address;
		this.state = state;
		this.city = city;
		this.contactNo = contact_no;
		this.email = email;
		this.userName = username;
		this.password = password;
	}

	public UserDetails() {
		super();
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", state=" + state + ", city=" + city + ", contactNo=" + contactNo + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", loginStatus=" + loginStatus + ", userType="
				+ userType + ", agentName=" + agentName + "]";
	}

	

}
