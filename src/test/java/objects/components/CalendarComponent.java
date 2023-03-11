package objects.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public static void setDate(String[] birthDMY) {
        $(".react-datepicker__month-select").selectOption(birthDMY[1]);
        $x("//*[@class='react-datepicker__year-select']").selectOption(birthDMY[2]);
        $(byText(birthDMY[0])).click();
    }
}
