package day3;

import static io.restassured.RestAssured.given;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HeadersDemo {

	
//	@Test(priority = 1)
	
	void testHeaders() {
		
		given()
		
		.when()
			.get("https://google.com/")
			
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
	}
	
	
	
	@Test(priority = 2)
	void getHeaders() {
		
	Response res =	given()
		
					.when()
						.get("https://google.com/");
		
		//Get Single Header Value
		//String headervalue = res.getHeader("Content-Type");
		//System.out.println("The value of Content-Type is: "+headervalue);
		
	
		//Get ALL Header Values
		Headers myHeaders = res.getHeaders();
		for(Header hd:myHeaders) {
			System.out.println(hd.getName()+"      "+hd.getValue());
		}
		
		
	}
	
	
}
