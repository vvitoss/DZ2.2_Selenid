package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @Test
    void CardDeliveryOrder(){
        Configuration.holdBrowserOpen = true;
        open("http://localhost:7777");
        $$x("//input[@type='text']").get(0).val("Тверь");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $$x("//input[@type='tel']").get(0).val("15.04.2022");
        $$x("//input[@type='text']").get(1).val("Лысак Виталий Леонидович");
        $$x("//input[@type='tel']").get(1).val("+79157481592");
        $("[data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно")).should(visible, Duration.ofSeconds(15));




    }
}
