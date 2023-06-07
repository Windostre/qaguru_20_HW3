package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = FIREFOX;
//        Configuration.browserVersion = "100.0"; // версия работать не будет
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successTest() {
        open("/text-box");

        $("#userName").setValue("Sveta Ivanova");
        $("#userEmail").setValue("ivanova@somemail.ru");
        $("#currentAddress").setValue("Pushkina ul., 34");
        $("#permanentAddress").setValue("Gogol-Mogol ul., 16a");
        $("#submit").click();

        $("#output #name").shouldHave(Condition.text("Sveta Ivanova"));
        $("#output #email").shouldHave(Condition.text("ivanova@somemail.ru"));
        $("#output #currentAddress").shouldHave(Condition.text("Pushkina ul., 34"));
        $("#output #permanentAddress").shouldHave(Condition.text("Gogol-Mogol ul., 16a"));

    }
}
