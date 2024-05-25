package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


class WebTest {
    @Test
    void cardTest() {
        open("http://localhost:9999");
        $("[data-test-id='city']").setValue("Москва");


        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        $x("//*[text()='Дата встречи']").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $x("//*[text()='Дата встречи']").sendKeys(futureDate.format(formatter));

        $("[data-test-id='name']").setValue("Елена");
        $("[data-test-id='phone']").setValue("+77772100609");
        $("data-test-id=agreement]").click();
        $("button").click();

        $("#spin_visible").should(disappear, Duration.ofSeconds(15));

        $(".notification__title").shouldHave(exactText("Успешно!"));

    }
}

