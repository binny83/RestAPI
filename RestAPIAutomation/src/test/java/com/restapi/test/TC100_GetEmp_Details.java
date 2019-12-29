package com.restapi.test;

import com.employeeRestAPI.base.RestAPIBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC100_GetEmp_Details extends RestAPIBase{
	
	@BeforeClass
	void getEmployersDetails() throws InterruptedException
	{
		log.info("----Getting Started TC100_GetEmp_Details-----");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
		httpRequest= RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/"+ empID);
	}
	@Test
	void validateResponseBody()
	{
		String responseBody = response.getBody().asString();
		log.info("Response Body is:" + responseBody);
		Assert.assertEquals(responseBody.contains(empID),true);
	}
	
	@Test
	void validateStatuscode()
	{
		int statusCode=response.getStatusCode();
		log.info("status code is:" +statusCode);
		 Assert.assertEquals(statusCode,200);
	}
	
	@Test
	void validateStatusLine()
	{
		String statusLine=response.getStatusLine();
		log.info("status Line is:" +statusLine);
		 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@AfterClass
	void tearDown() {
		log.info("-----Finished TC100_GetEmp_Details------");
	}
}
