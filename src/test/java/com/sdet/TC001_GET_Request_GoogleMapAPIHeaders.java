package com.sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

// Validate Weather API = Valid status & status line
public class TC001_GET_Request_GoogleMapAPIHeaders {
	@Test
	void getGoogleMapHeaders() {
		
		//Specify Base URI
		RestAssured.baseURI="http://maps.googleapis.com";
		
		//Specify Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml.mention full key over here:");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
	
		//Capture details of header from response
		
		//Capture details of content-type header
		String contentType=response.header("Content-Type");
		System.out.println("contentType is : "+ contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		//Capture details of content-type header
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("contentEncoding is : "+ contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		//Caputuring all the Headers from Response
		
		Headers allheaders = response.headers();
		
		for(Header  header:allheaders)
		{
			System.out.println(header.getName()+"   "+ header.getValue());
		}
		
	}

}
