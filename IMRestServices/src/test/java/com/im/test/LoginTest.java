package com.im.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LoginTest {
	static Client client;
	WebResource webResource;
	
	
@BeforeClass
	public static void setup() {
	client = Client.create();
}

@Test
public void testLogin() {
	webResource = client
			.resource("http://localhost:8080/imservices/login?username=srushti&password=srushti123");
	String request = webResource.get(String.class);
	assertNotNull(request);
}

@Test
public void testLoginWithIncorrectPassword() {
	webResource = client
			.resource("http://localhost:8080/imservices/login?username=srushti&password=123");
	String request = webResource.get(String.class);
	Assert.assertEquals("",request);
} 

	
	

}