package ru.netology.card;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.Val;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDelivery {
    @Test
   public void happyPath() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));



    }
    @Test
    public void invalidFieldCity() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Berlin");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='city'] .input__sub").should(visible, Duration.ofSeconds(15));



    }
    @Test
    public void emptyFieldCity() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='city'] .input__sub").should(visible, Duration.ofSeconds(15));



    }
    @Test
    public void wrongDate() {
        Configuration.holdBrowserOpen = true;
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
    public void invalidName() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Elena");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='name'] .input__sub").should(visible, Duration.ofSeconds(15));



    }
    @Test
    public void noName() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='name'] .input__sub").should(visible, Duration.ofSeconds(15));



    }
    @Test
    public void invalidPhone() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("89994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").should(visible, Duration.ofSeconds(15));



    }
    @Test
    public void noCheckBocks() {
        Configuration.holdBrowserOpen = true;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("div .button").click();
        $("[data-test-id='agreement'].input_invalid .checkbox__text").should(visible, Duration.ofSeconds(15));



    }



}
