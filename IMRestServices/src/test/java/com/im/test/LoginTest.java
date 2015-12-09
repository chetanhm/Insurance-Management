package com.im.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LoginTest extends TestCase {

	@Before
	void setup() {
	}

	@Test
	public void testLogin() {

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/login?username=srushti&password=srushti123");
		String request = webResource.get(String.class);
		String output = request.toString();

		assertEquals("{\"status\": \"ok\"}", output);
	}
	
	@Test
	public void testNoSuchUsername() {

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/login?username=srushsdsti&password=srushti123");
		String request = webResource.get(String.class);
		String output = request.toString();

		assertEquals("{\"status\":\"-1\"}", output);
	}
	@Test
	public void testWrongCredentials() {

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/login?username=srushti&password=sadasd");
		String request = webResource.get(String.class);
		String output = request.toString();

		assertEquals("{\"status\": \"fail\"}", output);
	}

}