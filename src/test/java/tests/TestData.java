package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {

    static Faker faker = new Faker(new Locale("de"));
    public static String[]
            genders = {"Female", "Male", "Other"},
            months = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"},
            subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Computer Science",
                    "Commerce", "English", "Hindi", "Maths", "Physics", "Social Studies"},
            hobbies = {"Sports", "Reading", "Music"},
            cities = {"Panipat", "Karnal"};

    public static String filename = "photo.jpg",
            name = faker.name().firstName(),
            lastName = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            gender = getRandomItemFromArray(genders),
            mobileNumber = String.valueOf(getRandomLargeNumber(1000000000, 9999999999L)),
            birthMonth = getRandomItemFromArray(months),
            birthYear = String.valueOf(getRandomInt(1900, 2100)),
            hobby = getRandomItemFromArray(hobbies),
            subject = getRandomItemFromArray(subjects),
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = getRandomItemFromArray(cities);


        public static int birthDay = getRandomInt(1, 28);
    }
