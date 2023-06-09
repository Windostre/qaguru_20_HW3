package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeFormSuccessTest() {
        open("/automation-practice-form");
        //WebDriverRunner.getWebDriver().manage().window().maximize();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Василиса");
        $("#lastName").setValue("Премудрая");
        $("#userEmail").setValue("pretty_vasya@mail.com");
        $("#userNumber").setValue("1234567890");
        $x("//label[contains(text(), 'Other')]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1989");
        $$("div.react-datepicker__day").get(5).click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/files/jpj/test.jpg"));
        $("#currentAddress").setValue("Лукомрье, Дуб Зеленый, 1");
        $x("//div[@id='state']//input").setValue("NCR").pressEnter();
        $x("//div[@id='city']//input").setValue("Delhi").pressEnter();
        $("#submit").click();
        //todo asserts
        $(".modal-content").should(Condition.appear);
        $x("//td[text()='Student Name']//following-sibling::td").shouldHave(Condition.text("Василиса Премудрая"));
        $x("//td[text()='Student Email']//following-sibling::td").shouldHave(Condition.text("pretty_vasya@mail.com"));
        $x("//td[text()='Gender']//following-sibling::td").shouldHave(Condition.text("Other"));
        $x("//td[text()='Mobile']//following-sibling::td").shouldHave(Condition.text("1234567890"));
        $x("//td[text()='Date of Birth']//following-sibling::td").shouldHave(Condition.text("01 September,1989"));
        $x("//td[text()='Subjects']//following-sibling::td").shouldHave(Condition.text("Hindi"));
        $x("//td[text()='Hobbies']//following-sibling::td").shouldHave(Condition.text("Reading"));
        $x("//td[text()='Picture']//following-sibling::td").shouldHave(Condition.text("test.jpg"));
        $x("//td[text()='Address']//following-sibling::td").shouldHave(Condition.text("Лукомрье, Дуб Зеленый, 1"));
        $x("//td[text()='State and City']//following-sibling::td").shouldHave(Condition.text("NCR Delhi"));
        $("#closeLargeModal").click();

    }
}
