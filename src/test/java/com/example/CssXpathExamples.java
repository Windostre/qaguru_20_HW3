package com.example;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
       // <input autocomplete="off" placeholder="name@example.com" type="email" class="mr-sm-2 form-control name = "email" id="userEmail" data-testid="email">
        //порядок классности локаторов
        //1 data-testid - добавляют для целей нужд автоматизаторов
        $("input[data-testid=email]").setValue("1");
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $x("//*[@data-testid='email']").setValue("1");
        $(byXpath("//*[@data-testid='email']")).setValue("1");

        // <input autocomplete="off" placeholder="name@example.com" type="email" class="mr-sm-2 form-control name = "email" id="userEmail">
        //2 по id
        $("[id=userEmail]").setValue("1");
        $("#userEmail").setValue("1");
        $("input#userEmail").setValue("1");

        // <input autocomplete="off" placeholder="name@example.com" type="email" class="mr-sm-2 form-control name = "email" >
        //3 по name
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");

        // <input autocomplete="off" placeholder="name@example.com" type="email" class="mr-sm-2 form-control >
        //4 по классу
        $("[class=form-control]").setValue("1");
        $(".form-control").setValue("1");
        $(".mr-sm-2.form-control").setValue("1");
        $("input.mr-sm-2.form-control").setValue("1");
        $x("//input[@class='mr-sm-2'][@class='form-control']").setValue("1");

        // <div autocomplete="off" placeholder="name@example.com" class="mr-sm-2>
       // <input type="email" class="form-control>
        //</div>
        //5 допустим, что 2 эллемента, один в другом
        $(".form-control .mr-sm-2 ").setValue("1");
        $("div.form-control input.mr-sm-2 ").setValue("1");
        $("div.form-control").$("input.mr-sm-2 ").setValue("1");

        //<div>Hello, qa.guru! </div>
        //6 по тексту
        $x("//div[@text='Hello, qa.guru!']").click();
        $(byText("Hello, qa.guru!")).click();
        $(withText("qa.guru")).click();



    }
}
