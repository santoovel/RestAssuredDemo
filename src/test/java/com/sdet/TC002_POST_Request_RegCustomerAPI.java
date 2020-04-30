package com.sdet;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_POST_Request_RegCustomerAPI {

 @Test
 public	void Registrationsuccessfull() {
	 //Specify Base URI
	 RestAssured.baseURI="http://restapi.demoqa.com/customer";
	 
	 // Request object
	 
	 RequestSpecification httpRequest= RestAssured.given();
	 
	 //Request payload sending along with post request
	 
	 JSONObject requestParams= new JSONObject();
	 
	 requestParams.put("FirstName", "Santhsh");
	 requestParams.put("LastName", "abcd67891");
	 requestParams.put("UserName", "abcd672");
	 requestParams.put("Password", "abcd671");
	 requestParams.put("Email", "abcd618@gmail.com");
	 
	 httpRequest.header("Content-Type","application/json");
	 
	 //attach above data to the request
	 httpRequest.body(requestParams.toJSONString());
	 
	 //Response object
	 Response response= httpRequest.request(Method.POST,"/register");
	 
	 String responseBody=response.getBody().asString();
	 System.out.println("Response body is : "+ responseBody);
	 
	 //status code validation
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("Status code is : "+ statusCode);
	 Assert.assertEquals(statusCode, 201);
	 
	 //Success code validation
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}
}
