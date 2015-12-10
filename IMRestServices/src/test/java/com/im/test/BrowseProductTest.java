package com.im.test;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class BrowseProductTest {
	
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		webResource = client
				.resource("http://localhost:8080/imservices/allProducts");
	}
	
	
	@Test
	public void testBrowse() {
	  String request = webResource.get(String.class);
		Assert.assertNotNull(request);
	}
	

}
