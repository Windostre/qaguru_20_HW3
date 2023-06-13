package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithCommentsTests {
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
        WebDriverRunner.getWebDriver().manage().window().maximize();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Василиса");
        $("#lastName").setValue("Премудрая");
        $("#userEmail").setValue("pretty_vasya@mail.com");
        $("#userNumber").setValue("1234567890");
        //$x("//label[contains(text(), 'Other')]").click(); //нежелательный
        //$("gender-radio-3").parent().click();//good
        //$(byText("Other")).click();//не очень, так как при тесте на др локалях язык может поменяться + может тыкнуть на другой other
        //$("label[for=gender-radio-3]").parent().click();//good
        $("#genterWrapper").$(byText("Other")).click(); //best
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        //$$("div.react-datepicker__day").get(5).click(); // мой вариант
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); //неплохо
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/files/jpj/test.jpg"));
        $("#currentAddress").setValue("Лукоморье, Дуб Зеленый, 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        //$("react-select-3-option-0").click(); // при использованиее Breakpoint не очень, так как не понятно, куда кликнули
        //$x("//div[@id='state']//input").setValue("NCR").pressEnter(); //мое решение
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
       // $x("//div[@id='city']//input").setValue("Delhi").pressEnter();  //мое решение
        $("#submit").click();

        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Василиса Премудрая"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("pretty_vasya@mail.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("30 July,1989"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Hindi"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("test.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Лукоморье, Дуб Зеленый, 1"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
        /*X-PATH */
//        $x("//td[text()='Student Name']//following-sibling::td").shouldHave(Condition.text("Василиса Премудрая"));
//        $x("//td[text()='Student Email']//following-sibling::td").shouldHave(Condition.text("pretty_vasya@mail.com"));
//        $x("//td[text()='Gender']//following-sibling::td").shouldHave(Condition.text("Other"));
//        $x("//td[text()='Mobile']//following-sibling::td").shouldHave(Condition.text("1234567890"));
//        $x("//td[text()='Date of Birth']//following-sibling::td").shouldHave(Condition.text("01 September,1989"));
//        $x("//td[text()='Subjects']//following-sibling::td").shouldHave(Condition.text("Hindi"));
//        $x("//td[text()='Hobbies']//following-sibling::td").shouldHave(Condition.text("Reading"));
//        $x("//td[text()='Picture']//following-sibling::td").shouldHave(Condition.text("test.jpg"));
//        $x("//td[text()='Address']//following-sibling::td").shouldHave(Condition.text("Лукомрье, Дуб Зеленый, 1"));
//        $x("//td[text()='State and City']//following-sibling::td").shouldHave(Condition.text("NCR Delhi"));
        $("#closeLargeModal").click();

    }
}
