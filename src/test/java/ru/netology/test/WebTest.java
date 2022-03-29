package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    LocalDate localDate = LocalDate.now().plusDays(4);
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String strData = localDate.format(data);

    @Test
    void CardDeliveryOrder(){
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").val("Тверь");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Лысак Виталий Леонидович");
        $("[data-test-id='phone'] input").val("+79157481592");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $("[class='notification__content']")
          .shouldHave(Condition.text("Встреча успешно забронирована на " + (strData) ), Duration.ofSeconds(15));






    }
}
