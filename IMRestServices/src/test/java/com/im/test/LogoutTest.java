package com.im.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LogoutTest {
	static Client client;
	WebResource webResource;	
	
@BeforeClass
	public static void setup() {
	client = Client.create();
}

@Test
public void testLogout() {
	webResource = client
			.resource("http://localhost:8080/imservices/logout?id=5667f5165dc94adc7229c73a");
	String request = webResource.get(String.class);
	assertNotNull(request);
}

@Test
public void testLogoutWithoutLoggedIn() {
	webResource = client
			.resource("http://localhost:8080/imservices/logout?id=5667f5165dc94adc7229i73a");
	String request = webResource.get(String.class);
	Assert.assertEquals("",request);
} 

	
	

}