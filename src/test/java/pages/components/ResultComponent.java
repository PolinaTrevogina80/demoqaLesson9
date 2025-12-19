package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private final SelenideElement
    //result
        resultModalPopup = $(".modal-dialog"),
        resultTitle = $("[id=example-modal-sizes-title-lg]"),
        resultTable = $("[class=table-responsive]");

    public ResultComponent checkFormAppears() {
        //Validations
        resultModalPopup.should(appear);
        resultTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ResultComponent checkResult(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public ResultComponent checkName(String firstName, String lastName) {
        checkResult("Student Name", firstName+" "+lastName);
        return this;
    }

    public ResultComponent checkEmail(String email) {
        checkResult("Student Email", email);
        return this;
    }

    public ResultComponent checkGender(String gender) {
        checkResult("Gender", gender);
        return this;
    }

    public ResultComponent checkNumber(String phoneNumber) {
        checkResult("Mobile", phoneNumber);
        return this;
    }

    public ResultComponent checkDate(String day, String month, String year) {
        checkResult("Date of Birth", day+" "+month+","+year);
        return this;
    }

    public ResultComponent checkSubject(String subject) {
        checkResult("Subjects", subject);
        return this;
    }

    public ResultComponent checkFileName(String fileName) {
        checkResult("Picture", fileName);
        return this;
    }

    public ResultComponent checkAddress(String address) {
        checkResult("Address", address);
        return this;
    }

    public ResultComponent checkStateAndCity(String state, String city) {
        checkResult("State and City", state+" "+city);
        return this;
    }

    public ResultComponent checkHobbies(List<String> hobbiesList) {
        HobbiesComponent hobbies = new HobbiesComponent();

        for (String hobby : hobbiesList) {
            resultTable.$(byText("Hobbies")).parent().shouldHave(text(hobbies.getHobby(hobby)));
        }
        return this;
    }

    public void checkFormNotAppears() {
        resultTitle.shouldNotBe(visible);
    }
}
