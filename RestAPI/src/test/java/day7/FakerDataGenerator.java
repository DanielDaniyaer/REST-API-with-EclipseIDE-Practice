package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

	@Test
	void testGenerateDummyData() {
		Faker faker = new Faker();
		String fullName = faker.name().fullName();
		String fisrtName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String userName = faker.name().username();
		String passWord = faker.internet().password(3, 15);
		String cellPhone = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		String creditCardNum = faker.business().creditCardNumber();
		System.out.println("Full name: "+fullName);
		System.out.println("Fist name: "+fisrtName);
		System.out.println("Last name: "+lastName);
		System.out.println("User name: "+userName);
		System.out.println("Password is: "+passWord);
		System.out.println("Cell Phone# is: "+cellPhone);
		System.out.println("Email is: "+email);
		System.out.println("Credit Card Number: "+creditCardNum);

	}
	
	
}
