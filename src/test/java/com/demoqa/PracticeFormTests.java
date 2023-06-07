package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillPracticeFormSuccessTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Улита");
        $("#lastName").setValue("Молтбу");
        $("#userEmail").setValue("moltbu2049@mail.uz");


    }
}
