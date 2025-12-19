package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {

    private final SelenideElement hobbyInput = $("#hobbiesWrapper");

    public void setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
    }

    public String getHobby(String hobby) {
        return switch (hobby) {
            case "Sports" -> getHobby1();
            case "Reading" -> getHobby2();
            case "Music" -> getHobby3();
            default -> "";
        };
    }

    public String getHobby1(){
        return "Sports";
    }

    public String getHobby2(){
        return "Reading";
    }

    public String getHobby3(){
        return "Music";
    }
}
