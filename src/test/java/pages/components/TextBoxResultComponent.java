package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxResultComponent {
    private final SelenideElement
            resultTable = $("[id=output]"),

            nameCheck = $("#output #name"),
            emailCheck = $("#output #email"),
            currentAddressCheck = $("#output #currentAddress"),
            permanentAddressCheck = $("#output #permanentAddress");

    public TextBoxResultComponent checkResultAppear() {
        resultTable.shouldBe(visible);
        return this;
    }

    public TextBoxResultComponent checkResultNotAppear() {
        resultTable.shouldNotHave(text("Name"));
        return this;
    }


    public TextBoxResultComponent checkResults(String name, String email,
                                            String currentAddress, String permanentAddress) {
        nameCheck.shouldHave(text("Name:"));
        nameCheck.shouldHave(text(name));

        emailCheck.shouldHave(text("Email:"));
        emailCheck.shouldHave(text(email));

        currentAddressCheck.shouldHave(text("Current Address :"));
        currentAddressCheck.shouldHave(text(currentAddress));

        permanentAddressCheck.shouldHave(text("Permananet Address :"));
        permanentAddressCheck.shouldHave(text(permanentAddress));
        return this;
    }
}
