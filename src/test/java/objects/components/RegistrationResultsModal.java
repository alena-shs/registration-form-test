package objects.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public static String transformBirthdayForValidation(String[] birthDMY) {
        String formattedDay = String.format("%02d", Integer.valueOf(birthDMY[0]));

        return formattedDay + " " + birthDMY[1] + "," + birthDMY[2];
    }

    public static void verifyModalAppears(){
        $(".modal-dialog").should(appear);
        $(".modal-header")
                .shouldHave(text("Thanks for submitting the form"));
    }

    public static void verifyModalContents(String key, String value) {
            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));
    }


}
