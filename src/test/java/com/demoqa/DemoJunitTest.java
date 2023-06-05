package com.demoqa;

import org.junit.jupiter.api.*;

public class DemoJunitTest {
    Calculator calc;

    @BeforeAll
    static void beforeAll() {
        System.out.println("#### @Before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("#### @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    #### @BeforeEach");
        calc = new Calculator();
    }

    @AfterEach
    void afterEach() {
        System.out.println("    #### @AfterEach");
        calc = new Calculator();
    }


    @Test
    void firstTest() {
        System.out.println("        #### @firstTest");
        int result = calc.sum(2,2);
        Assertions.assertEquals(4, result);
    }
    @Test
    void secondTest() {
        System.out.println("        #### @secondTest");
        int result =calc.mult(2,2);
        Assertions.assertEquals(4, result);
    }
}
