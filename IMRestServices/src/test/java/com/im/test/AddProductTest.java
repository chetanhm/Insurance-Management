package com.im.test;

import org.jglue.fluentjson.JsonBuilderFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class AddProductTest {
	static Client client;
	static WebResource webResource;

	@BeforeClass
	public static void setup() {
		client = Client.create();
		webResource = client
				.resource("http://localhost:8080/imservices/addProduct");
	}

	
	@Test
	public void testAddPolicyWithAuthentication() {
		JsonObject jsonObject = JsonBuilderFactory.buildObject()
				.add("productName", "asdasd")
				.add("basicCoverage", "3000")
				.add("accidentalBenefit","300")
				.add("settlementRatio","20")
				.add("monthlyPremium", "100")
				.addArray("productTerms").add("Term 1").add("Term 2").end()
				.add("description","Hello This is description")
				.add("termYear", "30").getJson();
		
	
		String insertData = jsonObject.toString();
		ClientResponse response = webResource.type("application/json").header("_id", "5668024dbea4a6fc24cbe951").post(
				ClientResponse.class, insertData);
			Assert.assertEquals(200, response.getStatus());

			
	}
	@Test
	public void testAddPolicyWithoutAuthentication() {
		JsonObject jsonObject = JsonBuilderFactory.buildObject()
				.add("productName", "asdasd")
				.add("basicCoverage", "3000")
				.add("accidentalBenefit","300")
				.add("settlementRatio","20")
				.add("monthlyPremium", "100")
				.addArray("productTerms").add("Term 1").add("Term 2").end()
				.add("description","Hello This is description")
				.add("termYear", "30").getJson();
		
	
		String insertData = jsonObject.toString();
		ClientResponse response = webResource.type("application/json").header("_id", "5668024dbea4a6fc24cbe951").post(
				ClientResponse.class, insertData);
			Assert.assertNotSame(200, response.getStatus());

	}
	@Test
	public void testAddPolicyWithWrongFields() {
		JsonObject jsonObject = JsonBuilderFactory.buildObject()
				.add("productName", "asdasd")
				.add("basicCoverage", "3000")
				.add("accidenasdstalBenefit","300")
				.add("settlementRatio","20")
				.add("monthlyPremium", "100")
				.addArray("productTerms").add("Term 1").add("Term 2").end()
				.add("description","Hello This is description")
				.add("termYear", "30").getJson();
		
	
		String insertData = jsonObject.toString();
		ClientResponse response = webResource.type("application/json").header("_id", "5668024dbea4a6fc24cbe951").post(
				ClientResponse.class, insertData);
			Assert.assertNotSame(200, response.getStatus());

	}

}