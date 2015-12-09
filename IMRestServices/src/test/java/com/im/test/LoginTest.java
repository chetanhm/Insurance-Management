package com.im.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class LoginTest extends TestCase {
	
	@Before
	void setup(){	
	}
	
	
@Test
	public void testLogin() {
		
		Client client=Client.create();
		WebResource webResource=client.resource("http://localhost:8080/login?username='Srushti'&password='srushti'");
		ClientResponse response=webResource.type("application/json").post(ClientResponse.class);
		
				String output = response.getEntity(String.class);
	assertEquals("{\"status\": \"ok\"}",output);
	}
}