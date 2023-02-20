import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void normalResult(){
        //Change variables here
        String filename = "photo.jpg";
        String name = "Gon";
        String lastName = "Freecs";
        String email = "email@test.com";
        String gender = "Male";
        String number = "1234567891";
        String birthDMY[] = new String[]{"1", "January", "2000"};
        String subject = "Maths";
        String hobby = "Sports";
        String address = "Avenue X 4202";
        String state = "Haryana";
        String city = "Panipat";

        //formatted birthday for validation
        String formattedDay = String.format("%02d", Integer.valueOf(birthDMY[0]));
        //photo file
        File photo = new File("src/test/resources/images/"+filename);


        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $x("//*[@id='userNumber']").setValue(number);
        $(byId("dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption(birthDMY[1]);
        $x("//*[@class='react-datepicker__year-select']").selectOption(birthDMY[2]);
        $(byText(birthDMY[0])).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFile(photo);
        $x("//*[@placeholder='Current Address']").setValue(address);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();

        $("#submit").click();

        $(".modal-header").shouldHave(
                text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text(name),
                text(lastName),
                text(gender),
                text(number),
                text(formattedDay + " "+ birthDMY[1]+","+birthDMY[2]),
                text(subject),
                text(hobby),
                text(filename),
                text(address),
                text(state),
                text(city));
    }
}