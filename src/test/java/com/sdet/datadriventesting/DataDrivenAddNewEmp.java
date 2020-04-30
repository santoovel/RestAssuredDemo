package com.sdet.datadriventesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDrivenAddNewEmp {
	
	@Test(dataProvider = "empdataprovider")
	void postNewEmployees(String ename,String esal,String eage) {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);
		
		// add a header stating the Request body is a json
		httpRequest.header("Content-Type","application/json");
		//add the json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/create");
		
		// capture response body to perform validations
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is : === "+ responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}

	
	@DataProvider(name="empdataprovider")
	String[][] getData(){
		String empdata[][] = {{"abcde123","30000","40"},{"jhk678","9000","43"},{"klj","7890","50"}};
		return(empdata);
	}
}
