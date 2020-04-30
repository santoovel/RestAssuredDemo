package com.sdet.restassured.bdd;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
public class Demo3_PUT_Request {
	public static HashMap map = new HashMap();
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int emp_id=1;
	
	@BeforeClass
	public void putData()
	{
		map.put("name", empName);
		map.put("salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPut() {
		given()
			.contentType("application/json")
			.body(map)
			
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
}
