package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class AppTest {

    @DataProvider
    public Object[][] parseData() {
        return new Object[][]{
                {1L, 0},
                {2L, 2},
                {479001600L, 12},
        };
    }

    @Test(dataProvider = "parseData")
    void multiTest(Long expected, int input) {
        assertEquals(expected, Factorial.count(input));
    }

    @Test
    void exceptionTesting() {
        assertThrows(
                () -> Factorial.count(-3)
        );
    }

    @Test(expectedExceptions = { ArithmeticException.class }, expectedExceptionsMessageRegExp = ".*Факториа́л.*")
    public void exceptionTestTwo() {
        Factorial.count(-10);
    }

}