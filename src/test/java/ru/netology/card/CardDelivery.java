package ru.netology.card;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CardDelivery {


    LocalDate localDate = LocalDate.now().plusDays(3);
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String strData = localDate.format(data);

    @Test
    public void happyPath() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void invalidFieldCity() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Berlin");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='city'] .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void emptyFieldCity() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='city'] .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void wrongDate() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='date'] .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void wrongDate2() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").val("12.03.2022");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='date'] .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void invalidName() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Elena");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='name'] .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void noName() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='name'] .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void invalidPhone() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("89994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").should(visible, Duration.ofSeconds(15));


    }

    @Test
    public void noCheckBocks() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(strData);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("div .button").click();
        $("[data-test-id='agreement'].input_invalid .checkbox__text").should(visible, Duration.ofSeconds(15));


    }


}
