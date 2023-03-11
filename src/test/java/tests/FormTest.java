package tests;

import objects.RegistrationPage;
import org.junit.jupiter.api.Test;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormPositiveTest() {
        //Change variables here
        String filename = "photo.jpg",
                name = "Gon",
                lastName = "Freecss",
                email = "email@test.com",
                gender = "Male",
                mobileNumber = "1234567891",
                subject = "Maths",
                hobby = "Sports",
                address = "Avenue X 4202",
                state = "Haryana",
                city = "Panipat";
        String[] birthDMY = new String[]{"1", "January", "2000"};

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