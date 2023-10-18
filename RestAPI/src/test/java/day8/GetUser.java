package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUser {

	@Test
	void test_GetUser(ITestContext context) {
		String bearerToken = "ee3a347a766e711971c29c6df784a6bce495f7e5e1c2489b46808a53f289d9db";
//		int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");

		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id",id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
}
