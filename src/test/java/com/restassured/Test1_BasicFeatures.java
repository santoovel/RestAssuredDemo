package com.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class Test1_BasicFeatures {

/*simply checking status code*/
	
	@Test
	public void testStatusCode(){
		given()
			.get("http://jsonplaceholder.typicode.com/posts/3")
		.then()
			.statusCode(200);
	}
	
	/* verify code and print complete response in console
	 * 
	 */
	//@Test
	public void testLogging(){
		given().get("http://services.groupkt.com/country/get/iso2code/in").
		then().statusCode(200).log().all();
	}
	
	/* verify single content using org.hamcrest.Matchers library
	 * 
	 */
	//@Test
	public void testEqualToFunction(){
		given().get("http://services.groupkt.com/country/get/iso2code/us").
		then().body("RestResponse.result.name", equalTo("United States Of America"));
	}
	
	/* verify Multiple content using org.hamcrest.Matchers library
	 * 
	 */
	//@Test
	public void testHasItemFunction(){
	//	given().get("http://services.groupkt.com/country/get/all").
		//then().statusCode(200).log().all().
		//then().body("RestResponse.result.name", hasItems("Afganistan","Argentina","Australia"));
	}
	
	/* parameters and headers can be set
	 * 
	 */
	//@Test
	public void testParametersandHeaders(){
		
			given().param("key1","value1").header("headA","valueA").when().get("http://services.groupkt.com/country/get/iso2code/gb").
			then().statusCode(200).log().all();
		}
	
	/* and to increase readability
	 * generally used when writing in one line xpath style
	 * 
	 */
	//@Test
	public void testandParametersandHeaders(){
		
			given().param("key1","value1").and().header("headA","valueA").when().get("http://services.groupkt.com/country/get/iso2code/cn").
			then().statusCode(200).log().all();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

