package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.HobbiesComponent;
import pages.components.ResultComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

        private final SelenideElement
                //user data
                fullNameInput = $("[id=userName"),
                userEmailInput = $("[id=userEmail"),
                currentAddressInput = $("[id=currentAddress"),
                permanentAddressInput = $("[id=permanentAddress"),
                submitButton = $("[id=submit]");

    public TextBoxPage openPage() {
            open("/text-box");
            $("[id=app]").shouldHave(text("Text Box"));
            return this;
        }

        public TextBoxPage removeAdds() {
            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
            return this;
        }

        //User data
        public TextBoxPage setFullName(String fullName) {
            fullNameInput.setValue(fullName);
            return this;
        }


        public TextBoxPage setUserEmail(String email) {
            userEmailInput.setValue(email);
            return this;
        }

        public TextBoxPage setCurrentAddress(String address) {
            currentAddressInput.setValue(address);
            return this;
        }

        public TextBoxPage setPermanentAddress(String address) {
            permanentAddressInput.setValue(address);
            return this;
        }

        public void submit() {
            submitButton.pressEnter();
        }

}
