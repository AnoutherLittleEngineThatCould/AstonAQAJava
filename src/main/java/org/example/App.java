package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( inputNumbersSumCheck( 2,11) );
         numberSign(0) ;
    }

    public static boolean inputNumbersSumCheck(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    public static void numberSign(int a){
        String sign = a >= 0 ? "положительное" : "отрицательное";
        System.out.println("Передали " + sign +" число");
    }
}
