package com.im.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class CalculatePremiumTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		
	}
	
	/**
	 * This test case returns the total premium of the user mentioned in userName 
	 */
	
//	@Test
//	public void testCalculatePremiumWithName() {
//		webResource = client
//				.resource("http://localhost:8080/imservices/getPremium?userName=surbhi");
//	  String request = webResource.get(String.class);
//		Assert.assertNotNull(request);
//	}
	
	/**
	 * This test case returns the total premium of the user whose value is not passed 
	 */
	@Test
	public void testCalculatePremium() {
		webResource = client
				.resource("http://localhost:8080/imservices/getPremium?userName=");
	  String request = webResource.get(String.class);
	  System.out.println(request);
		Assert.assertEquals("0", request);
	}

}
