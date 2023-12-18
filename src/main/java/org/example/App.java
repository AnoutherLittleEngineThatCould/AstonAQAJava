package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("--printThreeWords() : ");
        printThreeWords();
        System.out.print("--checkSumSign() : ");
        checkSumSign();
        System.out.print("--printColor() : ");
        printColor();
        System.out.print("--compareNumbers() : ");
        compareNumbers();


    }

    static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign(){
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        String result = (a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
        System.out.println(result);
    }

    static void printColor(){
        int value  = 600;
        if(value <= 0){
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else if(value > 100){
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers(){
        int a = 8000;
        int b = 80;

        String result = (a >= b ? "a >= b" : "a < b");
        System.out.println(result);


    }
}
