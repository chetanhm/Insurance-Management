package com.entity;

public class Registration {
	
	String firstName;
	String lastName;
	String address;
	String state;
	String city;
	String contact_no;
	String email;
	String username;
	String password;
	public Registration(String firstName, String fastName, String address, String state, String city, String contact_no,
			String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = fastName;
		this.address = address;
		this.state = state;
		this.city = city;
		this.contact_no = contact_no;
		this.email = email;
		this.username = username;
		this.password = password;
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
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
				+ state + ", city=" + city + ", contact_no=" + contact_no + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
		

}
