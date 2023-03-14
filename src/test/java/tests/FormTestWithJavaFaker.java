package tests;

import objects.RegistrationPage;
import objects.components.RegistrationResultsModal;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static tests.TestData.*;

public class FormTestWithJavaFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Test
    void studentRegistrationFormPositiveTest() {

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

        registrationResultsModal
                .verifyModalAppears()
                .verifyModalContents("Student Name", (name + " " + lastName))
                .verifyModalContents("Student Email", email)
                .verifyModalContents("Gender", gender)
                .verifyModalContents("Mobile", mobileNumber)
                .verifyModalContents("Date of Birth", ((new DecimalFormat("00").format(birthDay)) + " " + birthMonth + "," + birthYear))
                .verifyModalContents("Subjects", subject)
                .verifyModalContents("Hobbies", hobby)
                .verifyModalContents("Picture", filename)
                .verifyModalContents("Address", address)
                .verifyModalContents("State and City", (state + " " + city));
    }
}