package com.im.test;


import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ManagedCustomerTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		webResource = client
				.resource("http://localhost:8080/imservices/agent/atharva/user");
	}

	@Test
	public void testManagedCustomerDetails() {

		String managedCustomerData = "{\"firstName\":\"Srush\",\"lastName\":\"G\",\"address\":\"something\",\"state\":\"MH\",\"city\":\"something\",\"contactNo\":\"something\",\"email\":\"srushti@gmail.com\",\"userName\":\"srushti\",\"password\":\"srushti123\"}";
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, managedCustomerData);
		Assert.assertNotNull(response);

	}
	@Test
	public void testManagedCustomerRegistrationFail()
	{
		webResource = client
				.resource("http://localhost:8080/imservices/agent/seeya/user");
		String managedCustomerData =null;
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, managedCustomerData);
		Assert.assertEquals(400,response.getStatus());
	}
	


}