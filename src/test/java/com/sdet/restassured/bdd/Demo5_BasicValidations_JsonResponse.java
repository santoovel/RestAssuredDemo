package com.sdet.restassured.bdd;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

/*
 * 1. Test status code
 * 2) Log Response
 * 3) Verify single content in response body
 * 4) verify mul contents in res body
 * 5) setting parameters & headers
 */
public class Demo5_BasicValidations_JsonResponse {
// Test status code	
	@Test(priority=1)
	public void testStatusCode() {
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
		
		//given().when()..get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200).log().all();
	}
	
	//Log Response
	@Test(priority=2)
	public void testLogging() {
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//Verify single content in response body
	
	@Test(priority=3)
	public void testSingleContent() {
		given()
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.body("RestResponse.result.name",equalTo("India"));
	}
	
	//Verify Multiple content in response body
	
	@Test(priority=4)
	public void testMultipleContent() {
		given()
		.when()
			.get("http://services.groupkt.com/country/get/all")
		.then()
			.body("RestResponse.result.name",hasItems("India","Australia","United States of America"));
	}
	
	//setting parameters & headers
	
	@Test(priority=5)
	public void testParamsHeaders() {
		given()
			.param("MyName", "Santhosh")
			.header("MyHeader","Indian")
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
