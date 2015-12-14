

package com.im.test;

import static org.junit.Assert.assertNotNull;

import org.jglue.fluentjson.JsonBuilderFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class ApproveCustomerTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		
	}

	
	@Test
	public void testsetStatusDone()
	{
		String setStatus = "http://localhost:8080/imservices/policy?policyNumber=21119&status=approved";
		webResource = client.resource(setStatus);
		String response = webResource.type("application/json").put(String.class);
		System.out.println(response);
	
		Assert.assertNotNull(response);
				
	}
	

	
	
	
	
}
