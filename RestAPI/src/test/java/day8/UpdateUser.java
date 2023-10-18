package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

		@Test
		void test_UpdateUser(ITestContext context) {
			
//			int id = (int) context.getAttribute("user_id");
			int id = (int) context.getSuite().getAttribute("user_id");


			Faker faker = new Faker();
			
			JSONObject data =new JSONObject();
			
			data.put("name", faker.name().fullName());
			data.put("gender", "Male");
			data.put("email", faker.internet().emailAddress());
			data.put("status", "active");
			
			String bearerToken = "ee3a347a766e711971c29c6df784a6bce495f7e5e1c2489b46808a53f289d9db";
			
			given()
				.header("Authorization","Bearer "+bearerToken)
				.contentType("application/json")
				.pathParam("id", id)
				.body(data.toString())
			.when()
				.put("https://gorest.co.in/public/v2/users/{id}")

			.then()
				.statusCode(200)
				.log().all();
	}
	
	
}
