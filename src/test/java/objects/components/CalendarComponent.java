package objects.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public static void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $x("//*[@class='react-datepicker__year-select']").selectOption(year);
        $(byText(String.valueOf(day))).click();
    }
}
