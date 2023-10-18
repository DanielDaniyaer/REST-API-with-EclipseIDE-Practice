package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponData {
/*	
	@Test(priority=1)
	void testJsonResponse() {
*/		//Appoach1
/*		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/book")
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.body("[2].title",equalTo("The Lord of the Rings"));//JSON.path
*/
		//Approach2
/*		Response res=given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/book");

		Assert.assertEquals(res.getStatusCode(),200); //validation 1
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		
		String bookname=res.jsonPath().get("[2].title").toString();
		Assert.assertEquals(bookname,"The Lord of the Rings");
*/
	@Test(priority = 2)
	
	void testJsonResponseBodyData() {
		Response res=
				given()
					.contentType(ContentType.JSON)
				.when()
					.get("http://localhost:3000/book");
		
		//JSONObject class
		JSONObject jo= new JSONObject(res.toString());//Converting response to JSONObject Type
		for(int i=0;i<jo.getJSONArray("book").length(); i++) {
		String bookTitle = 	jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		System.out.println(bookTitle);
		
		}
		
	}
}
