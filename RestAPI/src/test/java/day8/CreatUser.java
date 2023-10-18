package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreatUser {
	@Test
	void test_creatUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data =new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "ee3a347a766e711971c29c6df784a6bce495f7e5e1c2489b46808a53f289d9db";
		
		int id = given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");		
		System.out.println("Generated id is: "+id);

//		context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);

	}
}
