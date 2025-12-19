package tests;

import data.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.logevents.SelenideLogger.step;


@Tag("demoqa")
@Tag("registration")
@Feature("Filling in Practice Form")
@Owner("PolinaTrevogina")
@DisplayName("Tests for filling in Practice Form at DEMOQA")
public class AutomationFormWithAllureNotationsTest extends TestBase {
    RegistrationPage registration = new RegistrationPage();
    ResultComponent result = new ResultComponent();



    @Test
    @Story("All fields filling")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "PracticeForm", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("If fill in all fields of Practice Form at DEMOQA and submit - " +
            "popup is shown with all filled in data correct")
    void fillFormFullTest() throws IOException, URISyntaxException {
    User user = new User();
    user.createUser();

        step("Open, fill and submit form page", () -> {
            registration.openPage()
                            .removeAdds()
                            .setFirstName(user.firstName)
                            .setLastName(user.lastName)
                            .setUserEmail(user.email)
                            .setPhoneNumber(user.phoneNumber)
                            .setGender(user.gender)
                            .setDate(user.birthDay, user.birthMonth, user.birthYear)
                            .setFile(user.fileName)
                            .setSubject(user.subject)
                            .setHobbies(user.hobbies)
                            .setAddress(user.streetAddress)
                            .setState(user.state)
                            .setCity(user.city)
                            .submit();
        });

        step("Check results", () -> {

            result.checkFormAppears()
                    .checkName(user.firstName, user.lastName)
                    .checkEmail(user.email)
                    .checkGender(user.gender)
                    .checkNumber(user.phoneNumber)
                    .checkDate(user.birthDay, user.birthMonth, user.birthYear)
                    .checkSubject(user.subject)
                    .checkHobbies(user.hobbies)
                    .checkFileName(user.fileName)
                    .checkAddress(user.streetAddress)
                    .checkStateAndCity(user.state, user.city);
        });
    }

    @Test
    @Story("Mandatory fields field")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "PracticeForm", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("If fill in only mandatory fields of Practice Form at DEMOQA and submit - \" +\n" +
            "            \"popup is shown with data correct in filled fields")
    void fillFormMinimumTest() throws IOException, URISyntaxException {
        User user = new User();
        user.createUser();

        step("Open, fill and submit form page", () -> {
        registration.openPage()
                .removeAdds()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setPhoneNumber(user.phoneNumber)
                .setGender(user.gender)
                .submit();
        });

        step("Check results", () -> {

        result.checkFormAppears()
                .checkName(user.firstName, user.lastName)
                .checkGender(user.gender)
                .checkNumber(user.phoneNumber);
        });
    }

    @Test
    @Story("Submiting empty form")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "PracticeForm", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("If sumbit empty form - no popup is shown")
    void negativeTest() {
            step("Open, fill and submit form page", () -> {
        registration.openPage()
                .removeAdds()
                .submit();
            });

            step("Check results", () -> {

        result.checkFormNotAppears();
            });
    }
}
