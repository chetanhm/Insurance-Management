package com.im.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class ApproveClaimTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		
	}

	
	@Test
	public void testsetStatusDone()
	{
		String setStatus = "http://localhost:8080/imservices/claim?id=567248dd23203311119403d3&claimStatus=approved";
		webResource = client.resource(setStatus);
		String response = webResource.type("application/json").put(String.class);
		System.out.println(response);
	
		Assert.assertNotNull(response);
				
	}

}
