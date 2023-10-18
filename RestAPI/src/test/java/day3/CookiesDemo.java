package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {

//	@Test(priority = 1)
	
	void testCookies() {
		
		given()
		
		.when()
			.get("https://google.com/")
			
		.then()
			.cookie("AEC","ARSKqsI2VR3C6ZkMzlaFbqm9THNB4CRFxR-WMToDj6H3uVvU5cEwYVp77w")
			.log().all();
	}
	
	@Test(priority = 2)
	
	void getCookiesInfo() {
		
		Response res=given()
		
		.when()
			.get("https://google.com/");
		//get single cookie info
		//String cookie_value=res.getCookie("AEC");
		//System.out.println("Value of cookie is ===>"+cookie_value);
		
		//get all cookies info
		Map<String,String> cookies_values = res.getCookies();
	//	System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet()){
		String cookie_value=res.getCookie(k);
		System.out.println(k+"    "+cookie_value);

	}
	}
}
