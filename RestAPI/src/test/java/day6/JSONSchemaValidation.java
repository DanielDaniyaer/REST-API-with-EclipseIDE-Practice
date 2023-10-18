/*
package day6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidation {
	
	@Test
	
	void jsonschemavalidation() {
		
		given()
		
		.when()
			.get("*url")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("*JsonSchema.json"));

	}
}

public class XMLschemaValidation{
	@Test
	
	void xmlSchemavalidation() {
		given()
		.when()
			.get("*url*")
		.then()
			.assertThat().body(RertAssureMatchers.matchesXsdInClasspath("***.xsd"));
	}
	

}
*/