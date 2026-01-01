package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.UpdateProfileRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Verify update profile API is working...")
	public void updateProfileAPITest() {
		
		LoginRequest loginRequest = new LoginRequest("DonnaP", "DonnaP1234");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("-------------------------------------------------------");
		
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		System.out.println("-------------------------------------------------------");
		
		UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder()
				.firstName("Rachale")
				.lastName("Zane")
				.email("rachale.zane@gmail.com")
				.mobileNumber("9878919281")
				.build();
		response = userManagementService.updateProfile(loginResponse.getToken(), updateProfileRequest);
		System.out.println(response.asPrettyString());
		
	}
}
