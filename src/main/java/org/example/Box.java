package org.example;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruitInBox = new ArrayList<>();

    private float boxWeight = 0f;

    public float getBoxWeight() {
        return boxWeight;
    }

    public List<T> getFruitInBox() {
        return fruitInBox;
    }

    public void add(T fruit) {
        fruitInBox.add(fruit);
        boxWeight += fruit.getWeight();
    }

    public boolean compare(Box<? extends Fruit> box) {
        float sigma = 0.0001f;
        return Math.abs(box.boxWeight - this.boxWeight) < sigma;
    }

    public void unionFruitBox(Box<T> box) {
        while (!box.fruitInBox.isEmpty()) {
            this.add(box.fruitInBox.remove(0));
        }
    }


}
