package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetUserProfileTest {
	
	@Test(description = "Verify Get Profile API is working...")
	public void getProfileInfoTest() {
		
		LoginRequest loginRequest = new LoginRequest("Lindan", "Lindan!001");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
		
	}

}
