package com.im.test;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AgentApplicationTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		webResource = client
				.resource("http://localhost:8080/imservices/imBecomeAgent");
	}

	@Test
	public void testAgentDetails() {

		String agentData = "{\"username\":\"Srushti\",\"age\":\"21\",\"lastQualification\":\"BE\",\"presentOccupation\":\"Trainee\",\"rewards\":\"something\",\"workExperience\":\"1\"}";
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, agentData);
		Assert.assertNotNull(response);

	}
	@Test
	public void testAgentDetailsFail()
	{
		String agentData =null;
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, agentData);
		Assert.assertEquals(400,response.getStatus());
	}
	
	@Test
	public void testAgentFails()
	{
		String agentData ="{\"username\":\"Hello\",\"age\":\"21\",\"lastQualification\":\"BE\",\"presentOccupation\":\"Trainee\",\"rewards\":\"something\",\"workExperience\":\"1\"}";
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, agentData);
		Assert.assertEquals(200,response.getStatus());
	}

}