package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcTest {

    @BeforeAll
    public static void setUp(){
        System.out.println("before all");
    }

    @BeforeEach
    public void setUpEach(){
        System.out.println("before each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Проверка суммирования 1")
    @Timeout(10) //10 секунд ждет, потом закрывает тест в случае не удачи
    @Tag("summ1") //теги нужны для дальнейших тестсьютов, что бы выделять смок\регресс и тд
    void summ1() {
        Calc calc = new Calc();
        int result = calc.summ(1,6);
        Assertions.assertEquals(7,result, "Неверный ответ");
    }

    @RepeatedTest(10) //проверка 10 раз тестов для стабильности
    @DisplayName("Рипит проверка суммирования 2")
    @Timeout(10) //10 секунд ждет, потом закрывает тест в случае не удачи
    @Tag("summ2") //теги нужны для дальнейших тестсьютов, что бы выделять смок\регресс и тд
    void summ2() {
        Calc calc = new Calc();
        int result = calc.summ(1,6);
        Assertions.assertEquals(7,result, "Неверный ответ");//сравнивает ожидаемый результат с фактическим результатом
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем {2}") //параметризованные тесты, нужны для выяснения граничных значений,проверка результат соответствует ожиданию
    @CsvSource({"1, 2, 3", "-1, 2, 1", "0, 0, 0"}) // 1 - это а, 2 - это б, 3- это результат соответствует действию 1+2=3
    @DisplayName("Проверка суммирования 3")
    @Tag("params")
    void summ3(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.summ(a,b);
        Assertions.assertEquals(expectedResult,result, "Неверный ответ"); //сравнивает ожидаемый результат с фактическим результатом
    }

}