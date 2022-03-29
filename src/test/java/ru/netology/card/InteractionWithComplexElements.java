package ru.netology.card;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InteractionWithComplexElements {
    LocalDate localDate = LocalDate.now().plusDays(3);
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String strData2 = localDate.format(data);


    @Test
    public void datePicker() {
        int dey = 4;

        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String oneData = localDate.plusDays(dey).format(data);

        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Омск");
        $(".menu-item__control").click();
        $(".input__icon").click();
        if (localDate.plusDays(dey).getMonth() != localDate.getMonth()) {
            $(".calendar__arrow[data-step='1']").click();
        }
        int data1 = localDate.plusDays(dey).getDayOfMonth();
        String strData = String.format(String.valueOf(data1));
        int element = $$("[role='gridcell'].calendar__day").size();
        for (int i = 0; i < element; i++) {
            String text = $$("[role='gridcell'].calendar__day").get(i).getText();
            if (text.equalsIgnoreCase(strData)) {
                $$("[role='gridcell'].calendar__day").get(i).click();
            }
        }
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));
        $(".notification__content")
                .should(Condition.text("Встреча успешно забронирована на " + oneData), Duration.ofSeconds(15));
    }

    @Test
    public void fieldAutocomplete() {

        open("http://0.0.0.0:9999/");
        $("[data-test-id='city'] input").val("Арх");
        $(".menu-item__control").click();
        $("[data-test-id='date'] input").val(strData2);
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));
        $(".notification__content")
                .should(Condition.text("Встреча успешно забронирована на " + strData2), Duration.ofSeconds(15));


    }


}

