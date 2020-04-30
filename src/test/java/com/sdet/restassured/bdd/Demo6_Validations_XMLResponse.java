package com.sdet.restassured.bdd;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class Demo6_Validations_XMLResponse {

	// Verify single content in rest XML response
	@Test(priority=1)
	public void testSingleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();		
	}
	
	// Verify Multiple contents in rest XML response
		@Test(priority=2)
		public void testMultipleContent() {
			
			given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
				.body("CUSTOMER.CITY", equalTo("Seattle"));
		}
		
		// Verify ALL the  contents in rest XML response
				@Test(priority=3)
				public void testALLContents() {
					
					given()
					.when()
						.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
					.then()
						.body("CUSTOMER.text()", equalTo("15BillSeattle"))
						.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
						
				}
		
		
		
	
}
