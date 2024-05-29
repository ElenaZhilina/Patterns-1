package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;



class WebTest {

    @BeforeEach
    void setUpAll() {
        open("http://localhost:9999");
    }


    @Test
    @DisplayName("Plan&Replan")
    void PlanReplan() {

        var city = DataGenerator.generateCity("ru");
        var name = DataGenerator.generateName("ru");
        var phone = DataGenerator.generatePhone("ru");

        $("[data-test-id='city'] input").setValue(city);
        $("[data-test-id='name'] input").setValue(name);
        $("[data-test-id='phone'] input").setValue(phone);

            Meeting firstMeeting = new Meeting();
        LocalDate firstMiting = LocalDate.now().plusDays(int daysToAddForFirstMeeting);

        firstMeeting.equals(firstMeeting);
        firstMeeting.setUser(validUser);

            Meeting secondMeeting = new Meeting();
        secondMeeting.setDate(secondMeetingDate);
        secondMeeting.setUser(validUser);

    }
        }



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            $("[data-test-id='date'] input").

            sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);

            $("[data-test-id='date'] input").

            sendKeys(futureDate.format(formatter));



            $("[data-test-id=agreement]").

            click();

            $$("button").

            find(Condition.exactText("Забронировать")).

            click();

            $(".notification__content").

            shouldBe(Condition.visible, Duration.ofSeconds(15))


        $("[data-test-id='city'] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);

        $("[data-test-id='city'] input").setValue(city);

        $("[data-test-id='date'] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);

        $("[data-test-id='date'] input").sendKeys(futureDate.format(formatter));

        $("[data-test-id='name'] input").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);

        $("[data-test-id='name'] input").setValue(name);

        $("[data-test-id='phone'] input").

                sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);

        $("[data-test-id='phone'] input").

                setValue(phone);

        $("[data-test-id=agreement]").

                click();

        $$("button").

                find(Condition.exactText("Забронировать")).

                click();

        $(".notification__content").

                shouldBe(Condition.visible, Duration.ofSeconds(15))


    }

    shouldHave(Condition.exactText("Встреча успешно забронирована на "+futureDate.format(formatter)));


}

