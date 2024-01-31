package org.example;

public class Factorial {

    public static Long count(int number) {
        Long res = 1L;
        if (number == 0) {
            return res;
        } else if (number > 0) {
            for (int i = 1; i <= number; i++) {
                res *= i;
            }
            return res;
        } else {
            throw new ArithmeticException("Факториа́л — функция, определённая на множестве неотрицательных целых чисел");
        }
    }
}
