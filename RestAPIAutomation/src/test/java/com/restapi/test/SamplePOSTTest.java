package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePOSTTest {
	
	@Test
	public void POSTCustomerDetails() {
		
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//sending Request Payload along with post object
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Brij");
		requestParams.put("LastName", "Patel");
		requestParams.put("UserName", "BrijP");
		requestParams.put("Password", "BBB");
		requestParams.put("Email", "brijpatel@gmail.com");
		
		httpRequest.header("Content-Type", "application/json"); 
		
		httpRequest.body(requestParams.toString());
		
		Response response = httpRequest.request(Method.POST, "/register");
		 
		String responseBody = response.getBody().asString();
		System.out.println("Respose Body is"+ responseBody);
		
		// To check for sub string presence get the Response body as a String.
		 // Do a String.contains
		 Assert.assertEquals(responseBody.contains("Brij") /*Expected value*/, true /*Actual Value*/, "Response body contains Brij");
		
		 //statusCode verification
		int statusCode = response.getStatusCode();
		System.out.println("status code is" + statusCode);
		Assert.assertEquals(statusCode,201);
		
		 //SuccessCode verification
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( successCode,"Correct Success code was returned");
	}

}
