package ru.netology.card;


import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InteractionWithComplexElements {
    LocalDate localDate = LocalDate.now().plusDays(3);


    @Test
    public void datePicker() {
        int dey = 4;
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $(".menu-item__control").click();
        $(".input__icon").click();
        if (localDate.plusDays(dey).getMonth() != localDate.getMonth()) {
            $(".calendar__arrow[data-step='1']").click();
        }
        int data = localDate.plusDays(dey).getDayOfMonth();
        String strData = String.format(String.valueOf(data));
        int element = $$("[role='gridcell'].calendar__day").size();
        for (int i = 0; i < element; i++) {
            String text = $$("[role='gridcell'].calendar__day").get(i).getText();
            if (text.equalsIgnoreCase(strData)) {
                $$("[role='gridcell'].calendar__day").get(i).click();
            }
            $("[data-test-id='name'] input").val("Елена");
            $("[data-test-id='phone'] input").val("+79994702121");
            $("[data-test-id='agreement']").click();
            $("div .button").click();
            $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));
        }
    }

    @Test
    public void fieldAutocomplete() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Арх");
        $(".menu-item__control").click();
        $("[data-test-id='date'] input").val("12.04.2022");
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));


    }


}

