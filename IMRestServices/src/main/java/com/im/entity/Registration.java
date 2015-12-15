package com.im.entity;

public class Registration {
	
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String city;
	private String contactNo;
	private String email;
	private String userName;
	private String password;
	private String userType;
	private String agentName;
	
	
	
	public Registration(String firstName, String fastName, String address, String state, String city, String contact_no,
			String email, String username, String password) {
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
	public Registration() {
		super();
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




	@Override
	public String toString() {
		return "Registration [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", state="
				+ state + ", city=" + city + ", contactNo=" + contactNo + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", userType=" + userType + ", agentName=" + agentName + "]";
	}
	
	
	
		

}
