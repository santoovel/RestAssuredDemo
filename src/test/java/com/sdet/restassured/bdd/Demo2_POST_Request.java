package com.sdet.restassured.bdd;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//http://restapi.demoqa.com/customer/register
public class Demo2_POST_Request {
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postdata() {
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		
		RestAssured.baseURI= "http://restapi.demoqa.com/customer";
		RestAssured.basePath= "/register";
	}

	@Test
	public void testpost()
	{
		given()
			.contentType("application/json")
			.body(map)
			
		.when()
			.post()
			
		.then()
			.statusCode(201)
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.body("Message",equalTo("Operation completed successfully"))
			.log().all();
	}
}
