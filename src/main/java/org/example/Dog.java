package org.example;

public class Dog extends Animal {
    public static final int DOG_MAX_RUN = 500;
    public static final int DOG_MAX_SWIM = 10;
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
    public void run(int distance) {
        if (distance < DOG_MAX_RUN && distance > 0) {
            System.out.printf("Пес %s пробежал %d м.", name, distance);
        } else if (distance < 0 && distance > -DOG_MAX_RUN) {
            System.out.printf("Пес %s пробежал %d м в другую сторону.", name, distance);
        } else if (distance == 0) {
            System.out.printf("Пес %s никуда не побежал.", name);
        } else {
            System.out.printf("Пес %s может пробежать только %d м, он остался на месте.", name, DOG_MAX_RUN);
        }
        System.out.println();
    }

    @Override
    public void swim(int distance) {
        if (distance < DOG_MAX_SWIM && distance > 0) {
            System.out.printf("Пес %s проплыл %dм.", name, distance);
        } else if (distance < 0 && distance > -DOG_MAX_SWIM) {
            System.out.printf("Пес %s проплыл %d м. в другую сторону.", name, distance);
        } else if (distance == 0) {
            System.out.printf("Пес %s никуда не проплыл.", name);
        } else {
            System.out.printf("Пес %s может проплыть только %dм, он остался на суше.", name, DOG_MAX_SWIM);
        }
        System.out.println();
    }
}
