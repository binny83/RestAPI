package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleDeleteTest {
	
	@Test
	public void DeleteRecords() {
		
		int empid = 15410;
		 
		 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		 RequestSpecification httpRequest = RestAssured.given();
		 
		// Add a header stating the Request body is a JSON
		 httpRequest.header("Content-Type", "application/json"); 
		 
		 // Delete the request and check the response
		 Response response = httpRequest.request(Method.DELETE, "/delete/"+ empid);
		
		// String responseBody = response.getBody().asString();
		// System.out.println("Respose Body is"+ responseBody);
			
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		 String jsonString =response.asString();
		 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
		 
	}

}


