package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        //**Task 1**
        System.out.println("**Task 1:");
        Random random = new Random();
        List<Integer> integersRandomList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(1000); i++) {
            integersRandomList.add(random.nextInt(1000));
        }
        List<Integer> evenNumbersList = integersRandomList.stream().filter(o -> o % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbersList);
        //**Task 2**
        System.out.println("**Task 2:");
        List<String> stringList = new ArrayList<>(4);
        stringList.add("Highload");
        stringList.add("High");
        stringList.add("Load");
        stringList.add("Highload");
        // Посчитать, сколько раз объект «High» встречается в коллекции;
        System.out.print(stringList.stream().filter(o -> o.equals("High")).count());
        System.out.println(" раз объект «High» встречается в коллекции");
        //Определить, какой элемент в коллекции находится на первом месте. Если мы получили пустую коллекцию,
        //то пусть возвращается 0;
        System.out.print(stringList.isEmpty() ? 0 : stringList.get(0));
        System.out.println(" элемент в коллекции находится на первом месте");
        //Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0;
        System.out.print(stringList.isEmpty() ? 0 : stringList.get(stringList.size() - 1));
        System.out.println(" элемент в коллекции находится на последнем месте");
        //**Task 3**
        System.out.println("**Task 3:");
        //Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
        //Необходимо отсортировать строки по возрастанию и добавить их в массив;
        List<String> fCollection = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        fCollection.addAll(fCollection.stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.substring(1))))
                .collect(Collectors.toList()));
        System.out.println(fCollection);
        //**Task 4**
        System.out.println("**Task 4:");
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN));
        Double avgAge = students.stream()
                .filter(o -> o.getGender().equals(Gender.MAN))
                .mapToInt(Student::getAge).average().orElse(0);
        System.out.printf("Средний возраст среди студентов мужчин: %.2f\n", avgAge);
        List<Student> studentsForMilitaryServe = students.stream().filter(o -> o.getAge() >= 18
                        && o.getAge() <= 27
                        && o.getGender().equals(Gender.MAN))
                .collect(Collectors.toList());
        System.out.println("Кандидаты на вручение повесток :" + studentsForMilitaryServe);
        //**Task 5 **
        System.out.println("**Task 5:");
        System.out.println("Введите логин...");
        Scanner sc = new Scanner(System.in);
        String inputLine;
        List<String> userLogin = new ArrayList<>();
        while (!(inputLine = sc.nextLine().trim()).isEmpty()) {
            userLogin.add(inputLine);
        }
        System.out.println("Логины начинающиеся с f - " + userLogin.stream()
                .filter(o -> o.startsWith("f"))
                .collect(Collectors.toList()));
    }
}
