package tests;

import objects.RegistrationPage;
import org.junit.jupiter.api.Test;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormPositiveTest() {
        //Change variables here
        String filename = "photo.jpg";
        String name = "Gon";
        String lastName = "Freecss";
        String email = "email@test.com";
        String gender = "Male";
        String mobileNumber = "1234567891";
        String[] birthDMY = new String[]{"1", "January", "2000"};
        String subject = "Maths";
        String hobby = "Sports";
        String address = "Avenue X 4202";
        String state = "Haryana";
        String city = "Panipat";

        //formatted birthday for validation

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(name)
                .setLastNameLocator(lastName)
                .setEmailLocator(email)
                .setGender(gender)
                .setMobileNumberLocator(mobileNumber)
                .setBirthDate(birthDMY)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(filename)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage.confirmResultsAppears()
                .confirmResultsContent("Student Name", (name+" "+lastName))
                .confirmResultsContent("Student Email", email)
                .confirmResultsContent("Gender", gender)
                .confirmResultsContent("Mobile", mobileNumber)
                .confirmResultsContent("Date of Birth", registrationPage.formatBirthdayForValidation(birthDMY))
                .confirmResultsContent("Subjects", subject)
                .confirmResultsContent("Hobbies", hobby)
                .confirmResultsContent("Picture", filename)
                .confirmResultsContent("Address", address)
                .confirmResultsContent("State and City", (state+" "+city));
    }
}