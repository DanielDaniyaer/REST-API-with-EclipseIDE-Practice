/*
package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.Pojo_PostRequest;

//POJO --Serilize--> JSON Object --De-Serilize--> POJO

public class SerilizationDeserilization {

	
	//Pojo ==> JSON (Serilization)
	@Test
	
	void ConvertPojo2Json() {
		 
		Student stupojo = new Student)();
		
		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("123456");
		stupojo.coursesArr[]= {"C","C++"};
		stupojo.setCourses(coursesArr);
		
		//convert java object-->json object (serilization)
		ObjectMapper objMapper=new ObjectMapper();
		
	String jsondata	objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		System.out.println(jsondata);
		
	}
	
}

	//Json --->Pojo (De-Serilization)
		

		void convertJson2Pojo() throws JsonProcessingException {
			String jsondata=" {\r\n" + 
					"					\"name\":\"Scott\",\r\n" + 
					"					\"location\":\"France\",\r\n" + 
					"					\"phone\":\"123546\",\r\n" + 
					"					\"courses\":[\"C\",\"C++\"]\r\n" + 
					"			}";
			
			ObjectMapper objMapper =new ObjectMapper();
			Student stupojo= objMapper.readValue(jsondata,Student.class);
			System.out.println(stupojo.getName());
			System.out.println(stupojo.getLocation());
			System.out.println(stupojo.getPhone());
			System.out.println(stupojo.getCourses()[0]);
			System.out.println(stupojo.getCourses()[1]);
			
		
		}

*/

