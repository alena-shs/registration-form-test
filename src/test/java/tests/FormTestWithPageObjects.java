package tests;

import objects.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class FormTestWithPageObjects extends TestBase {
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
                birthMonth = "January",
                birthYear = "2000",
                subject = "Maths",
                hobby = "Sports",
                address = "Avenue X 4202",
                state = "Haryana",
                city = "Panipat";
        int birthDay = 1;

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(mobileNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(filename)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage.confirmResultsAppears();
        registrationPage.confirmResultsContent("Student Name", (name + " " + lastName))
                .confirmResultsContent("Student Email", email)
                .confirmResultsContent("Gender", gender)
                .confirmResultsContent("Mobile", mobileNumber)
                .confirmResultsContent("Date of Birth", ((new DecimalFormat("00").format(birthDay)) + " " + birthMonth + "," + birthYear))
                .confirmResultsContent("Subjects", subject)
                .confirmResultsContent("Hobbies", hobby)
                .confirmResultsContent("Picture", filename)
                .confirmResultsContent("Address", address)
                .confirmResultsContent("State and City", (state + " " + city));
    }
}