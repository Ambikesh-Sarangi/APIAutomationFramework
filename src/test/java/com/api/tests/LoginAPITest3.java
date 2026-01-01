package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest3 {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("Lindan", "Lindan!001");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getId(), 3619);
		
		
	}

}
