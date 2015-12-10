package com.im.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ViewProductTest {
	static Client client;
	WebResource webResource;
	
	
@BeforeClass
	public static void setup() {
	client = Client.create();
}

@Test
public void testViewDetails() {
	webResource = client
			.resource("http://localhost:8080/imservices/viewProduct?productName=Seva");
	String request = webResource.get(String.class);
	assertNotNull(request);
}




	
	

}