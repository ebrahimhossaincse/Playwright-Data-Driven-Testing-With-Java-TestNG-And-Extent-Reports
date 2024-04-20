package ebrahim.hossain.sqa.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import ebrahim.hossain.sqa.basedriver.BaseDriver;

public class CommonMethods extends BaseDriver {

	public void fillField(Locator field, String value) throws IOException {
		field.fill(value);
	}

	public void testDataGenerator() throws FileNotFoundException, IOException {

		Faker faker = new Faker();

		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password = faker.internet().password(6, 10);

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);

		ExcelUtils excelUtils = new ExcelUtils();

		excelUtils.writeExcelData(firstName, lastName, email, password);

	}
}
