package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author AnoutherLittleEngineThatCould
 * @link github.com/AnoutherLittleEngineThatCould
 */
class FactorialTest {
// Почему-то не видит зависимость, в отдельном проекте все работает
// @ParameterizedTest(name = "{index} test {1}! = {0}")
//  @CsvSource(value = {"1, 1", "2, 2", "479001600, 12"})
// void multiTest(Long expected, int input) {
//    Assertions.assertEquals(expected, Factorial.count(input));
//  }

    @Test
    void factorialOneTest() {
        Assertions.assertEquals(39916800, Factorial.count(11));
    }

    @Test
    void factorialTwoTest() {
        Assertions.assertEquals(39916800, Factorial.count(11));
    }

    @Test
    void exceptionTesting() {
        Exception thrown = assertThrows(
                ArithmeticException.class,
                () -> Factorial.count(-10)
        );
        assertEquals("Факториа́л — функция, определённая на множестве неотрицательных целых чисел",
                thrown.getMessage());
    }

}