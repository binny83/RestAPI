package com.restapi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleGETGoogleMap {
	
	@Test
	public void GetGoogleMap() {
	
	//Specify the base URL to the RESTful web service
			RestAssured.baseURI="http://maps.googleapis.com";
		
			//Get the RequestSpecification of the request that you want to sent
			RequestSpecification httpRequest= RestAssured.given();
			
			// Make a request to the server by specifying the method Type and the method URL.
			 // This will return the Response from the server. Store the response in a variable.
			 Response response = httpRequest.request(Method.GET, "/maps/");
			 
			 // Now let us print the body of the message to see what response
			 // we have received from the server
			 String responseBody = response.getBody().asString();
			 System.out.println("Response Body is"+ responseBody);
			
			 //Headers verification
			 String contentType=response.header("Content-Type");
			 System.out.println("content type is"+contentType);
			 Assert.assertEquals(contentType,"application/json; charset=utf-8");
			 
			 //Header content Encoding
			 String contentEncoding=response.header("Content-Encoding");
			 System.out.println("Content Encoding "+ contentEncoding);
			 Assert.assertEquals(contentEncoding,"gzip");
			 
			 //Header via 
			 String via=response.header("Via");
			 System.out.println("Via "+ via);
			 Assert.assertEquals(via,"1.1 vegur");
	}
}
