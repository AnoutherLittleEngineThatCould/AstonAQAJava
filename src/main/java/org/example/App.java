package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Task 1: " + inputNumbersSumCheck( 2,11) );
        System.out.print("Task 2: ");
        numberSign(0) ;
        System.out.println("Task 3: " + isNegative(5));
        System.out.println("Task 4: ");
        printStringNTimes("Java", 3);
        System.out.println("Task 5: " + isLeapYear(2000));
        System.out.print("Task 6: ");
        replaceZeroesAndOne();
        System.out.print("Task 7: ");
        fillArray();
        System.out.print("Task 8: ");
        increaseSmallNumberInArray();

    }
    //Task 1
    public static boolean inputNumbersSumCheck(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }
    //Task 2
    public static void numberSign(int a){
        String sign = a >= 0 ? "положительное" : "отрицательное";
        System.out.println("Передали " + sign +" число");
    }
    //Task 3
    public static boolean isNegative(int number){
        return number < 0;
    }
    //Task 4
    public static void printStringNTimes(String s, int n){
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }
    //Task 5
    public static boolean isLeapYear(int year){
        if(year % 100 == 0){
            return year % 400 == 0;
        }  else return year % 4 == 0;
    }
    //Task 6
    public static void replaceZeroesAndOne(){
        int[] array = new int[]{1,1,0,0,1,0,1,1,0,0};

        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                array[i] = 1;
            }
            else array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }
    //Task 7
    public static void fillArray(){
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }
    //Task 8
    public static void increaseSmallNumberInArray(){
        int[] array = new int[]{1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6){
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    //Task 9
    public static void modifyDiagonalInArray(){
        int[][] array = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

    }
}
