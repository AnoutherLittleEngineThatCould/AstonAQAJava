package org.example;

public class App 
{
    public static void main( String[] args )
    {
        //Инициализируем объекты
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Apple a4 = new Apple();
        Apple a5 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        //Создаем коробки
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        //Заполняем коробки
        orangeBox.add(o1);
        orangeBox.add(o2);
        appleBox.add(a1);
        appleBox.add(a2);
        appleBox.add(a3);
        appleBox1.add(a4);
        appleBox1.add(a5);
        //Результаты
        System.out.println("appleBox: " + appleBox.getBoxWeight() );
        System.out.println("orangeBox: " + appleBox.getBoxWeight() );
        System.out.print("Compare: ");
        System.out.println(appleBox.compare(orangeBox));
        System.out.println("***Before union boxes***");
        System.out.println("appleBox:");
        System.out.println(appleBox.getFruitInBox());
        System.out.println("appleBox1:");
        System.out.println(appleBox1.getFruitInBox());
        System.out.println("*Union*");
        appleBox.unionFruitBox(appleBox1);
        //orangeBox.unionFruitBox(appleBox1); - так нельзя <Orange> не будет сравнивать с <Apple>
        System.out.println("appleBox:");
        System.out.println(appleBox.getFruitInBox());
        System.out.println("appleBox1:");
        System.out.println(appleBox1.getFruitInBox());
        System.out.print("appleBox.getBoxWeight() after union: ");
        System.out.println(appleBox.getBoxWeight());
    }
}
