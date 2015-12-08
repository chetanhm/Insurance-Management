package com.registrationtest;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegistrationTest extends TestCase {
	
	@Before
	void setup(){	
	}
	@Test
	public void testRegister() {
		
		Client client=Client.create();
		WebResource webResource=client.resource("http://localhost:8080/imregister");
		
String registerData ="{\"firstName\":\"Srushti\",\"lastName\":\"G\",\"address\":\"something\",\"state\":\"MH\",\"city\":\"something\",\"contact_no\":\"something\",\"email\":\"srushti@gmail.com\",\"username\":\"srushti\",\"password\":\"srushti123\"}";

		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class,registerData);
		String output = response.getEntity(String.class);
assertEquals("{\"firstName\":\"Srushti\",\"lastName\":\"G\",\"address\":\"something\",\"state\":\"MH\",\"city\":\"something\",\"contact_no\":\"something\",\"email\":\"srushti@gmail.com\",\"username\":\"srushti\",\"password\":\"srushti123\"}",output);
	}

}