package com.restapi.test;

import org.testng.annotations.Test;
//import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
//import static org.junit.Assert.assertThat;

public class SampleAuthentication {
 
    @Test
    public void basicAuthenticationTest() {
 
        RestAssured.baseURI = "http://localhost:8006";
 
        Response response = null;
 
        String invalidusername = "deepak";
        String invalidpassword = "";
 
        String validusername = "isha";
        String validpassword = "durani";
 
 
        //Scenario with incorrect username & password
        response = given()
            .auth().basic(invalidusername, invalidpassword)
            .when()
            .get("/agents");
 
        System.out.println("Access Unauthorized \nStatus Code :" + response.getStatusCode());
        System.out.println("Response :" + response.asString());
 
        System.out.println("\n---------------------------------------------------\n");
 
        //Scenario with correct username & password	
        response = given()
            .auth().basic(validusername, validpassword)
            .when()
            .get("/agents");
 
        System.out.println("Access Authorized \nStatus Code :" + response.getStatusCode());
        System.out.println("Response :" + response.asString());
    }
 
}
 