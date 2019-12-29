package com.employeeRestAPI.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAPIBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="257888"; //Emp id for Get employee details and Update employee details
	public static final Logger log=Logger.getLogger(RestAPIBase.class);

	
	@BeforeClass
	public void setup()
	{
		//logger=Logger.getLogger("EmployerRestAPI");
		//logger.setLevel(Level.DEBUG);
		log.info("EmployerRestAPI");
		log.debug("Employer details");
	}
	
	
}