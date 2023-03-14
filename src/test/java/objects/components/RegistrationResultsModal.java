package objects.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public RegistrationResultsModal verifyModalAppears(){
        $(".modal-dialog").should(appear);
        $(".modal-header")
                .shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationResultsModal verifyModalContents(String locatorText, String inputtedText) {
            $(".table-responsive").$(byText(locatorText)).parent()
                    .shouldHave(text(inputtedText));

            return this;
    }

}
