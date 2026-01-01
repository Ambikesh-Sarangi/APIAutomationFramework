package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify Signup API is working...")
	public void signupTest() {
		
		SignupRequest signupRequest = new SignupRequest.Builder()
		.username("DonnaP")
		.email("donna.paulsen001@gmail.com")
		.firstName("Donna")
		.lastName("Paulsen")
		.password("DonnaP1234")
		.mobileNumber("9876543210").build();
		
		AuthService authService = new AuthService();
		Response response = authService.signup(signupRequest);
		System.out.println(response.asPrettyString());
	}

}
