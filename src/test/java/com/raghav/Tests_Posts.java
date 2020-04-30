package com.raghav;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Tests_Posts {
	
	//@Test
	 void test_01_Post() {
	
		//Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("name", "Raghav");
		//map.put("job", "Teacher");
		//System.out.println(map);
		 
		JSONObject request = new JSONObject();
		request.put("name", "Santhosh");
		request.put("Job", "Software Engineer");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
			  
			}
			  
	
	
	//@Test
	 void test_02_Put() {
		JSONObject request = new JSONObject();
		request.put("name", "Santhosh");
		request.put("Job", "Software Engineer");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
			  
			}
			  
	//@Test
	 void test_03_Patch() {
		JSONObject request = new JSONObject();
		request.put("name", "Santhosh");
		request.put("Job", "Software Engineer");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
			  
			}
	 
	 @Test
	 void test_04_Delete() {
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
			}
}
