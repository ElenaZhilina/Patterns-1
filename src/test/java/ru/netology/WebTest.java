package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.nio.channels.FileChannel.open;

class WebTest {
    @Test
    void webTest() {
        open("http://localhost:9999");
        $("[data-test-id='city']").setValue("Москва");

        $("[data-test-id='name']").setValue("Елена");
        $("[data-test-id='phone']").setValue("+77772100609");
        $("[data-test-id='agreement']").click();

        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }

    private DataProcessingException $(String s) {
    }
}
