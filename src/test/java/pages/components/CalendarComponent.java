package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    //Calendar
    private final SelenideElement yearSelector = $("[class=react-datepicker__year-select]");
    private final SelenideElement monthSelector = $("[class=react-datepicker__month-select]");
    private final SelenideElement daySelecctor = $("[class=react-datepicker__month-container]");

    public void setDay(String day) {
        daySelecctor.findElement(byText(day)).click();
    }

    public void setMonth(String month) {
        monthSelector.selectOption(month);
    }

    public void setYear(String year) {
        yearSelector.selectOptionByValue(year);
    }

}
