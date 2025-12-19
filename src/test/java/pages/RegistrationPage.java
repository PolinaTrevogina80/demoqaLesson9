package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.HobbiesComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private final SelenideElement
            //user data
            firstNameInput = $("[id=firstName"),
            lastNameInput = $("[id=lastName"),
            userEmailInput = $("[id=userEmail"),
            genderInput = $("#genterWrapper"),
            phoneNumberInput = $("[id=userNumber"),
            fileInput = $("input[type='file']"),
            subjectsInput = $("[id=subjectsInput"),

    //address
            currentAddressInput = $("[id=currentAddress"),
            stateSelector = $("[id=react-select-3-input"),
            citySelector = $("[id=react-select-4-input"),
    //submit button
            submitButton = $("[id=submit]");

    //calendar
    private final SelenideElement calendarControl = $("[id=dateOfBirthInput");
    private final CalendarComponent calendar = new CalendarComponent();

    private final HobbiesComponent hobbies = new HobbiesComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $("[id=app]").shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage removeAdds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    //User data
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        calendarControl.click();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject);
        subjectsInput.pressTab();
        return this;
    }

    public RegistrationPage setHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            if ((hobby.equals("Sports")) || (hobby.equals("Reading")) || (hobby.equals("Music"))) {
                this.hobbies.setHobby(hobby);
            }
        }
        return this;
    }

    public RegistrationPage setFile(String fileName) {
        fileInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateSelector.setValue(state);
        stateSelector.pressTab();
        return this;
    }

    public RegistrationPage setCity(String city) {
        citySelector.setValue(city);
        citySelector.pressTab();
        return this;
    }

    public void submit() {
        submitButton.pressEnter();
    }

}
