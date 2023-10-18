package day5;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
/*
	@Test
	
	void singleFileUpload() 
	{
		File myfile=new File("*location*");

		given()
			.multiPart("file",myfile)
			.contentType("multiPart/from-data")
		.when()
			.post("*url*")
		
		.then()
			.statusCode(200)
			.body("fileName",equalTo("Text1.txt"))
					.log().all();
	}
*/	
//	@Test
	
	void multiFileUpload1() 
	{
		File myfile1=new File("*location1*"); 
		File myfile2=new File("*location2*"); 

		given()
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)

			.contentType("multiPart/from-data")
		.when()
			.post("*url*")
		
		.then()
			.statusCode(200)
			.body("[0].fileName",equalTo("Text1.txt"))
			.body("[1].fileName",equalTo("Text1.txt"))

					.log().all();
	}
	

	@Test
	
	void multiFileUpload2() // wont work for all kinds API *****
	{
		File myfile1=new File("*location1*"); 
		File myfile2=new File("*location2*"); 
		
		File filearr[]= {myfile1,myfile2};
		
		given()
			.multiPart("files",filearr)

			.contentType("multiPart/from-data")
		.when()
			.post("*url*")
		
		.then()
			.statusCode(200)
			.body("[0].fileName",equalTo("Text1.txt"))
			.body("[1].fileName",equalTo("Text1.txt"))

					.log().all();
	}
	
	@Test
	
	void testDownload() {
		given()
		
		.when()
			.get("*url*")
		.then()
			.statusCode(200)
			.log().body();
	}
	
	
	
}
