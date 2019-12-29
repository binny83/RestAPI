package com.restapi.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeRestAPI.base.RestAPIBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC101_POSTEmp_Details extends RestAPIBase{
	
	@BeforeClass
	void PostEmpDetails() throws InterruptedException 
	{

	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	//Request Object
	 httpRequest = RestAssured.given();
	
	//sending Request employer deatils along with post object
	JSONObject requestParams = new JSONObject();
	requestParams.put("FirstName","Dhoni");
	requestParams.put("LastName","Sign");
	requestParams.put("UserName","dhonisign");
	requestParams.put("Password","dj@83");
	requestParams.put("Email","someuser@gmail.com");
	
	httpRequest.header("Content-Type", "application/json"); 
	
	httpRequest.body(requestParams.toString());
	
	response = httpRequest.request(Method.POST, "/register");
}
	@Test
	void validateResponseBody()
	{
		String responseBody = response.getBody().asString();
		log.info("Response Body is:" + responseBody);
		Assert.assertEquals(responseBody.contains("Dhoni"),true); 
		Assert.assertEquals(responseBody.contains("Sign"),true); 
		
	}
	@Test
	void validateStatusCode()
	{
		int statusCode = response.getStatusCode();
		log.info("status code is" + statusCode);
		Assert.assertEquals(statusCode,200);
	}
	@Test
	void validateContentType()
	{
		String contentEncoding=response.header("Content-Encoding");
		log.info("Content Encoding "+ contentEncoding);
		Assert.assertEquals(contentEncoding,"gzip");
	}
}
