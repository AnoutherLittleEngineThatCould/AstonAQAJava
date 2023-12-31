package org.example;

import static org.example.Cat.CatBowl.getCapacity;

public class Cat extends Animal {
    private static final int CAT_CAN_EAT = 10;
    private static int catCount = 0;
    private String name;
    private boolean satiety;


    public Cat(String name) {
        super(name);
        catCount++;
        this.name = name;
    }

    public static int getCatCount() {
        return catCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public void run(int distance) {
        if (distance < 200 && distance > 0) {
            System.out.printf("Кот %s пробежал %dм.", name, distance);
        } else if (distance < 0 && distance > -200) {
            System.out.printf("Кот %s пробежал %dм в другую сторону.", name, -distance);
        } else if (distance == 0) {
            System.out.printf("Кот %s никуда не побежал.", name);
        } else {
            System.out.printf("Кот %s может пробежать только 200м, он остался на месте.", name);
        }
        System.out.println();
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Кот %s не умеет плавать.\n", name);
    }

    public void eat() {
        if (CAT_CAN_EAT < getCapacity()) {
            CatBowl.removeFoodFromCatBowl(CAT_CAN_EAT);
            setSatiety(true);
            System.out.printf("Кот %s успешно поел, осталось еды " + Cat.CatBowl.getCapacity() + "\n", name);
        } else {
            System.out.printf("Коту %s мало еды... наполните миску \n", name);
        }
    }

    static class CatBowl {
        private static int capacity;

        public CatBowl() {
        }

        public CatBowl(int capacity) {
            CatBowl.capacity = capacity;
        }

        public static int getCapacity() {
            return capacity;
        }

        public static void setCapacity(int capacity) {
            CatBowl.capacity = capacity;
        }

        public void fillCatBowl(int foodValue) {
            setCapacity(foodValue + getCapacity());
            System.out.println("Миска наполнена");
        }

        public static void removeFoodFromCatBowl(int catEatsValue) {
            if (catEatsValue < getCapacity()) {
                setCapacity(getCapacity() - catEatsValue);

            }
        }


    }
}

