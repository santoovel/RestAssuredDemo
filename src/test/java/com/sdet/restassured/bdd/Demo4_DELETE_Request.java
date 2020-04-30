package com.sdet.restassured.bdd;
import static io.restassured.RestAssured.given;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
public class Demo4_DELETE_Request {
	@Test
	public void deleteEmployeeRecord() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/11493";
		Response response = 
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		String jsonAsString= response.asString();
		Assert.assertEquals(jsonAsString.concat("Not able to delete record"),true);
	}
}
