package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePUTTest {
	
	@Test
	public void UpdateRecords(){
		 
		int empid = 15410;
		 
		 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "Zion"); // Cast
		 requestParams.put("age", 23);
		 requestParams.put("salary", 12000);
		 
		
		 httpRequest.body(requestParams.toString());
		 Response response = httpRequest.request(Method.PUT, "/update/"+ empid);
		
		 String responseBody = response.getBody().asString();
		 System.out.println("Respose Body is"+ responseBody);
			
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		 
	}

}

