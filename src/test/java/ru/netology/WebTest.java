package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class WebTest {

    LocalDate futureDate = LocalDate.now().plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    public void cardTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");

        $("[data-test-id='date'] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id='date'] input").sendKeys(futureDate.format(formatter));

        $("[data-test-id='name']").setValue("Елена");
        $("[data-test-id='phone']").setValue("+77772100609");
        $("data-test-id=agreement]").click();
        $("button").click();

        $(".notification__title")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Успешно!"));

    }
}

