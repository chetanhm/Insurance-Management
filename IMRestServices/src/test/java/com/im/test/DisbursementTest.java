package com.im.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class DisbursementTest {
	static Client client;
	WebResource webResource;
	
	
@BeforeClass
	public static void setup() {
	client = Client.create();
}

@Test
public void testDisbursement() {
	webResource = client
			.resource("http://localhost:8080/imservices/claim?userName=srushti");
	String request = webResource.get(String.class);
	assertNotNull(request);
}

@Test
public void testDisbursementOfUnclaimedPolicy() {
	webResource = client
			.resource("http://localhost:8080/imservices/claim?userName=srushti1");
	String request = webResource.get(String.class);
	Assert.assertEquals("[]",request);
} 

	
	

}