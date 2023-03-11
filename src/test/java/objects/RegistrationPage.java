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
    private final SelenideElement
            firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            emailLocator = $("#userEmail"),
            mobileNumberLocator = $x("//*[@id='userNumber']"),
            calendarButton = $(byId("dateOfBirthInput")),
            subjectLocator = $("#subjectsInput"),
            uploadLocator = $("#uploadPicture"),
            addressLocator = $x("//*[@placeholder='Current Address']"),
            stateLocator = $(byText("Select State")),
            cityLocator = $(byText("Select City")),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        Selenide.open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameLocator.setValue(name);

        return this;
    }

    public RegistrationPage setLastNameLocator(String lastName) {
        lastNameLocator.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmailLocator(String email) {
        emailLocator.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public RegistrationPage setMobileNumberLocator(String mobileNumber) {
        mobileNumberLocator.setValue(mobileNumber);

        return this;
    }

    public RegistrationPage setBirthDate(String[] birthDMY) {
        calendarButton.click();
        CalendarComponent.setDate(birthDMY);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectLocator.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        $(byText(hobby)).click();

        return this;
    }

    public RegistrationPage setPicture(String filename) {
        File photo = new File("src/test/resources/images/" + filename);
        uploadLocator.uploadFile(photo);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressLocator.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateLocator.click();
        $(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityLocator.click();
        $(byText(city)).click();

        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public String formatBirthdayForValidation(String[] birthDMY) {

        return RegistrationResultsModal.transformBirthdayForValidation(birthDMY);
    }


    public RegistrationPage confirmResultsAppears() {
        RegistrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage confirmResultsContent(String locatorText, String inputtedText) {

        RegistrationResultsModal.verifyModalContents(locatorText, inputtedText);

        return this;
    }


}
