package ru.netology.card;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class InteractionWithComplexElements {
    LocalDate localDate = LocalDate.now().plusDays(3);
    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd.MM.yyyy");



    @Test
    public void datePicker() {
        int dey = 4;
        String oneData = localDate.plusDays(dey).format(data);

        open("http://localhost:9999/");
        $("[data-test-id='city'] input").val("Ом");
        $$(".menu-item__control").find(text("Омск")).click();
        $(".input__icon").click();
        if (localDate.plusDays(dey).getMonth() != localDate.getMonth()) {
            $(".calendar__arrow[data-step='1']").click();
        }
        String strData = localDate.plusDays(dey).format(DateTimeFormatter.ofPattern("d"));
        $$("[role='gridcell'].calendar__day").findBy(exactText(strData)).click();
//        int data1 = localDate.plusDays(dey).getDayOfMonth();
//        String strData = String.format(String.valueOf(data1));
//        int element = $$("[role='gridcell'].calendar__day").size();
//        for (int i = 0; i < element; i++) {
//            String text = $$("[role='gridcell'].calendar__day").get(i).getText();
//            if (text.equalsIgnoreCase(strData)) {
//                $$("[role='gridcell'].calendar__day").get(i).click();
//            }
//        }
        $("[data-test-id='name'] input").val("Елена");
        $("[data-test-id='phone'] input").val("+79994702121");
        $("[data-test-id='agreement']").click();
        $("div .button").click();
        $("[data-test-id='notification'] .notification__title").should(visible, Duration.ofSeconds(15));
        $(".notification__content")
                .should(Condition.text("Встреча успешно забронирована на " + oneData), Duration.ofSeconds(15));
    }



}

