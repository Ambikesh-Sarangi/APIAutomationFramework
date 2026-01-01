package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{\"username\": \"Lindan\", \"password\": \"Lindan!001\"}");
//		RequestSpecification k = y.body("{\"username\": \"Lindan\",\"password\": \"Lindan!001\", \"email\": \"Lindan@gmail.com\", \"firstName\": \"Lindan\", \"lastName\": \"Badminton\", \"mobileNumber\": \"7461240719\"}");
		Response response = z.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}

}
