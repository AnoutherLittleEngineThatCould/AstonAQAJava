package org.example;

public class Dog extends Animal{
    private static int dogCount = 0;
    public Dog(String name) {
        super(name);
        this.name = name;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance){
        if (distance < 500 && distance > 0) {
            System.out.printf("Пес %s пробежал %dм.", name, distance);
        } else if (distance < 0 && distance > -500) {
            System.out.printf("Пес %s пробежал %d м. в другую сторону.", name, distance);
        } else if (distance == 0) {
            System.out.printf("Пес %s никуда не побежал.", name);
        } else {
            System.out.printf("Пес %s может пробежать только 500м, он остался на месте.", name);
        }
        System.out.println();
    }

    @Override
    public void swim(int distance){
        if (distance < 10 && distance > 0) {
            System.out.printf("Пес %s проплыл %dм.", name, distance);
        } else if (distance < 0 && distance > -10) {
            System.out.printf("Пес %s проплыл %d м. в другую сторону.", name, distance);
        } else if (distance == 0) {
            System.out.printf("Пес %s никуда не проплыл.", name);
        } else {
            System.out.printf("Пес %s может проплыть только 10м, он остался на суше.", name);
        }
        System.out.println();
    }
}
