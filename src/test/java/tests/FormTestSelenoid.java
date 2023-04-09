package tests;

import objects.RegistrationPage;
import objects.components.RegistrationResultsModal;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

@Tags({
        @Tag("JavaFaker"),
        @Tag("Remote")})
public class FormTestSelenoid extends TestBaseSelenoid {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Test
    void studentRegistrationFormPositiveTest() {
        step("Open the page", () -> {
            registrationPage.openPage();
        });
        step("Remove the banners", () -> {
            registrationPage.removeBanners();
        });
        step("Fill in the form with JavaFaker", () -> {
            registrationPage
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
                    .setCity(city);
                });
        step("Submit the form form", () -> registrationPage.submitForm());
        step("Check if the modal appears", () -> {
            registrationResultsModal.verifyModalAppears();
        });
        step("Check if all the data in the modal is correct", () -> {
            registrationResultsModal
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
        });
    }
}