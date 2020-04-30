package com.sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


// Validate Weather API = Valid status & status line

public class TC001_GET_Request_WeatherAPI {
	
	@Test
	void getweatherDetails() {
		
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		Assert.assertEquals(responseBody.contains("Hyderabad"), true );
		
		//status code validation
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		
		String statusLine=response.getStatusLine();
		System.out.println("statusLine is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		// to get indivudual elements
		JsonPath jsonpath= response.jsonPath();
		System.out.println("City is : "+ jsonpath.get("City"));
		System.out.println("Temperature is : "+ jsonpath.get("Temperature"));
		
		Assert.assertEquals(jsonpath.get("Temperature"), "25.16 Degree celsius");
		
		
		
	}

}
