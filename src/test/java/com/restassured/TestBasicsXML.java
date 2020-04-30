package com.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
public class TestBasicsXML {

/* To test xml for single body content*/
	
	//@Test
	public void testSingleContent(){
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
			then().body("CUSTOMER.ID", equalTo("10")).log().all();		
	}
	
	
	/* To test xml for Multiple body content*/
	//@Test
	public void testMultipleContent(){
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
		body("CUSTOMER.ID", equalTo("10")).
		body("CUSTOMER.FIRSTNAME", equalTo("Sue")).body("CUSTOMER.LASTNAME", equalTo("Fuller")).
		body("CUSTOMER,STREET", equalTo("135 Upland Pl.")).body("CUSTOMER.CITY", equalTo("Dallas"));
		
	}
	

	/* To testComplete text in one go*/
	//@Test
	public void testCompletetext(){
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
		body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).log().all();
	}
	
	

	/* xpath to find values*/
	//@Test
	public void testusingXPath(){
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
	}
	
	//Xpath
	@Test
	public void testUsingXpath2(){
		given().get("http://www.thomas-bayer.com/sqlrest/INVOICE").
		then().body(hasXPath("/INVOICEList/INVOICE[text()='40']"));
	}
	
}

