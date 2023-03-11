package objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import objects.components.CalendarComponent;
import objects.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $x("//*[@id='userNumber']"),
            calendarButton = $(byId("dateOfBirthInput"));

    public RegistrationPage openPage() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setNumber(String number) {
        numberInput.setValue(number);

        return this;
    }

    public RegistrationPage setBirthDate(String[] birthDMY) {
        calendarButton.click();
        CalendarComponent.setDate(birthDMY);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        $(byText(hobby)).click();

        return this;
    }

    public RegistrationPage setPicture(String filename) {
        File photo = new File("src/test/resources/images/" + filename);
        $("#uploadPicture").uploadFile(photo);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        $x("//*[@placeholder='Current Address']").setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        $(byText("Select State")).click();
        $(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        $(byText("Select City")).click();
        $(byText(city)).click();

        return this;
    }

    public void submitForm() {
        $("#submit").click();
    }

    public String formatBirthdayForValidation(String[] birthDMY) {

        return RegistrationResultsModal.transformBirthdayForValidation(birthDMY);
    }


    public RegistrationPage confirmResultsAppears() {
        RegistrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage confirmResultsContent(String key, String value) {

        RegistrationResultsModal.verifyModalContents(key, value);

        return this;
    }


}
