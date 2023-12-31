package org.example;

abstract class Animal {


    private static int animalCount;
    public String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }
}
