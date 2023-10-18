package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentications {

	@Test(priority=1)
	void testBasicAuthentications() {
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	@Test(priority=2)
	void testDigestAuthentications() {
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}

	@Test(priority=3)
	void testPreemptiveAuthentications() {
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
//	@Test(priority=4)
	
	void testBearerTokenAuthentications() {
		String bearerToken="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";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		
	}
//	@Test(priority=5)
	void testOauth1Authorization() {
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken") //for Oauth1.0 Authorization
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test(priority=6)
	void testOauth2Authorization() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/users/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=7)
	void testAPIKeyAuthorization() {
		given()
			.queryParam("parameterName", "parameterValues")
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
}