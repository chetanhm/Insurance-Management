package com.im.test;

import org.jglue.fluentjson.JsonBuilderFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class AddPolicyTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		webResource = client
				.resource("http://localhost:8080/imservices/addPolicy");
	}

	
	@Test
	public void testAddPolicyWithAuthentication() {
		JsonObject jsonObject = JsonBuilderFactory.buildObject()
				.add("productName", "asdasd")
				.add("annualIncome", "2000")
				.add("smoker","no")
				.add("incomeProofFile","852_AngularJS.pdf")
				.add("residenceProofFile", "819_AngularJS.pdf")
				.add("ageProofFile","884_AngularJS.pdf")
				.add("photoFile","884_AngularJS.pdf")
				.add("userName" , "admin")
				.getJson();
		
	
		String insertData = jsonObject.toString();
		ClientResponse response = webResource.type("application/json").header("_id", "5668024dbea4a6fc24cbe951").post(
				ClientResponse.class, insertData);
			Assert.assertEquals(200, response.getStatus());

			
	}
	
	@Test
	public void testAddPolicyWithWrongAuthentication() {
		JsonObject jsonObject = JsonBuilderFactory.buildObject()
				.add("productName", "asdasd")
				.add("annualIncome", "2000")
				.add("smoker","no")
				.add("incomeProofFile","852_AngularJS.pdf")
				.add("residenceProofFile", "819_AngularJS.pdf")
				.add("ageProofFile","884_AngularJS.pdf")
				.add("photoFile","884_AngularJS.pdf")
				.add("userName" , "admin")
				.getJson();
		
	
		String insertData = jsonObject.toString();
		ClientResponse response = webResource.type("application/json").header("_id", "56680244a6fc24cbe951").post(
				ClientResponse.class, insertData);
			Assert.assertEquals(0, response.getLength());

			
	}
}
