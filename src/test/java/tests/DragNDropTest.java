package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragNDropElementTest() {
        open("/drag_and_drop");

        //Проверка расположение квадратов ДО теста
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        //Драг-н-дроп через Element
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        //Проверка расположение квадратов ПОСЛЕ теста
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

    @Test
    void dragNDropActionTest() {
        open("/drag_and_drop");

        //Проверка расположение квадратов ДО теста
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        //Драг-н-дроп методом action, первый вариант
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        //Проверка расположение квадратов ПОСЛЕ теста
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


        //Драг-н-дроп методом action, второй вариант
        actions().dragAndDrop($("#column-a"),$("#column-b")).perform();

        //Проверка расположение квадратов ПОСЛЕ теста
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }
}
