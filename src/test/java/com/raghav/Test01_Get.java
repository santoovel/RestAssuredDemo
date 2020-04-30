package com.raghav;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;


//March 17 2020

public class Test01_Get {
	
	@Test
	void test_01() {	
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		 int statusCode=response.getStatusCode();
		 Assert.assertEquals(statusCode, 200);	 
	}
	
	@Test
	void test_02() {
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
	}
	
	
}
