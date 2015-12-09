package com.im.test;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegistrationTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		webResource = client
				.resource("http://localhost:8080/imservices/imregister");
	}

	@Test
	public void testRegistrationDone() {

		String registerData = "{\"firstName\":\"Srush\",\"lastName\":\"G\",\"address\":\"something\",\"state\":\"MH\",\"city\":\"something\",\"contactNo\":\"something\",\"email\":\"srushti@gmail.com\",\"userName\":\"srushti\",\"password\":\"srushti123\"}";
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, registerData);
		Assert.assertNotNull(response);

	}
	
	@Test
	public void testRegistrationFail()
	{
		String registerData =null;
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, registerData);
		Assert.assertEquals(400,response.getStatus());
	}

}