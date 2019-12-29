package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleGetTest {

	@Test
	public void GetEmployerDetails()
	{
		//Specify the base URL to the RESTful web service
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee/";
		
		
		//Get the RequestSpecification of the request that you want to sent
		
			RequestSpecification httpRequest= RestAssured.given();
	
			Response response = httpRequest.request(Method.GET, "/1");
		
		 // Now let us print the body of the message to see what response
		 // we have received from the server
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is"+ responseBody);
		 Assert.assertEquals(responseBody.contains("f"),true);
		
		 //statusCode verification
		 int statusCode=response.getStatusCode();
		 System.out.println("status code is"+statusCode);
		 Assert.assertEquals(statusCode,200,"Correct ststus code returned");
		 
		 //statusLine verification
		 String statusLine=response.getStatusLine();
		 System.out.println("status Line is"+statusLine);
		 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		 
	}
	
}
