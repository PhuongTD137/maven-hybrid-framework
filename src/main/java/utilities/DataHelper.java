package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	Locale locale = new Locale("en");
	Faker faker = new Faker(locale);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getCityName() {
		return faker.address().cityName();
	}

	public String getPhoneName() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getPassword() {
		return faker.internet().password(6, 10, true, true);
	}

	public String getCompanyName() {
		return faker.company().name();
	}
}
