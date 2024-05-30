package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


class WebTest {

    @BeforeEach
    void setUpAll() {
        open("http://localhost:9999");
    }


    @Test
    @DisplayName("PlanReplan")
    void PlanReplan() {

        var newUser = DataGenerator.Registration.generateUser("ru");
        var daysAddForFirstMeet = 3;
        var firstMeetDate = DataGenerator.generateDate(daysAddForFirstMeet);
        var daysAddForSecondMeet = 5;
        var secondMeetDate = DataGenerator.generateDate(daysAddForSecondMeet);

        $("[data-test-id='city'] input").setValue(newUser.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id='date'] input").sendKeys(firstMeetDate);
        $("[data-test-id='name'] input").setValue(newUser.getName());
        $("[data-test-id='phone'] input").setValue(newUser.getPhone());
        $("[data-test-id=agreement]").click();
        $$(".button__content").find(Condition.exactText("Запланировать")).click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + firstMeetDate));

        $("[data-test-id='date'] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        $("[data-test-id='date'] input").sendKeys(secondMeetDate);
        $$(".button__content").find(Condition.exactText("Запланировать")).click();
        $("[data-test-id=replan-notification] .notification__content")
                .shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(Condition.visible);
        $("[data-test-id=replan-notification] button").click();
        $("[data-test-id=success-notification] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + secondMeetDate))
                .shouldBe(Condition.visible);

    }
}


