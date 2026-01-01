package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description = "Verify is forgot password api is working...")
	public void forgotPasswordTest() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("donna.paulsen001@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
