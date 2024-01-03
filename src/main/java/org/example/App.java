package org.example;

/**
 * lesson 5 Vladimir Levin
 */
public class App {
    public static void main(String[] args) {
        // Task 1 :
        System.out.println("Task 1:");
        //Cat create
        Cat cat1 = new Cat("Boris");
        Cat cat2 = new Cat("Ron");
        Cat cat3 = new Cat("Flappy");
        Cat cat4 = new Cat("Rik");
        Cat cat5 = new Cat("Tom");
        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4, cat5};
        System.out.println("* Проверка двигательной активности котов");
        cat1.run(25);
        cat3.run(1000);
        cat2.swim(0);
        System.out.println("* Проверка пищевого поведения котов");
        Cat.CatBowl catBowl = new Cat.CatBowl(45);
        for (Cat c :
                cats) {
            c.eat();
        }
        catBowl.fillCatBowl(30);
        for (Cat c :
                cats) {
            if (!c.isSatiety()) {
                c.eat();
            }
        }
        // Dog create
        Dog dog1 = new Dog("Rex");
        Dog dog2 = new Dog("Snoopy");
        System.out.println("* Проверка двигательной активности собак");
        dog1.run(350);
        dog2.run(3500);
        dog1.swim(5);

        System.out.printf("* В результате работы программы создано Animal - %d(Cat - %d, Dog - %d)\n", Animal.getAnimalCount(), Cat.getCatCount(), Dog.getDogCount());
        //Task 2:
        System.out.println("Task 2: ");
        Triangle triangle = new Triangle(3, 4, 5, "Red", "Green");
        System.out.printf("Треугольник: площадь - %.2f, периметр - %.2f, цвет фона - %s, цвет границы - %s\n",
                triangle.calculateSquare(), triangle.calculatePerimeter(), triangle.colorBackground, triangle.colorBorder);
        Rectangle rectangle = new Rectangle(5, 6, "White", "Yellow");
        System.out.printf("Прямоугольник: площадь - %.2f, периметр - %.2f, цвет фона - %s, цвет границы - %s\n",
                rectangle.calculateSquare(), rectangle.calculatePerimeter(), rectangle.colorBackground, rectangle.colorBorder);
        Circle circle = new Circle(5, "Gray", "Purple");
        System.out.printf("Круг: площадь - %.2f, периметр - %.2f, цвет фона - %s, цвет границы - %s\n",
                circle.calculateSquare(), circle.calculatePerimeter(), circle.colorBackground, circle.colorBorder);
        System.out.println("В результате работы программы созданы :\n" + triangle + '\n' + rectangle + '\n' + circle + '\n');


    }
}
