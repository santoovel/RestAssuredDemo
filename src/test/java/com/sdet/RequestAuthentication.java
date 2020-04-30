package com.sdet;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RequestAuthentication {

	@Test
	public void AuthenticationBasics()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentication
	
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
		
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		
		System.out.println("Status message " + response.body().asString());
		
		System.out.println("Status code: " + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
