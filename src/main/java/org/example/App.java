package org.example;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //Task 1:
        System.out.println("Task 1: ");
        String[] words = new String[]{"foo", "boo", "bar", "bar", "buzz", "anotherFoo", "foo", "word"
                , "frog", "boo", "boo"};
        Map<String, Integer> uniqWordsFrequency = new HashMap<>();
        for (String s :
                words) {
            uniqWordsFrequency.put(s, !uniqWordsFrequency.containsKey(s) ? 1 : uniqWordsFrequency.get(s) + 1);
        }
        System.out.println("Все слова, которые есть в массиве");
        for (String s :
                uniqWordsFrequency.keySet()) {
            System.out.print(s + "; ");
        }
        System.out.println();
        System.out.println("Слова, которые встречаются только один раз");
        for (String s :
                uniqWordsFrequency.keySet()) {
            if (uniqWordsFrequency.get(s) == 1)
                System.out.print(s + "; ");
        }
        System.out.println();
        System.out.println("Сколько раз слова встречаются в массиве:");
        System.out.println(uniqWordsFrequency);
        //Task 2
        System.out.println("Task 2: ");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(Map.of("Ivanov", "+123456789"));
        phoneBook.add(Map.of("Petrov", "+321654789"));
        phoneBook.add(Map.of("Ivanov", "+456123789"));
        phoneBook.add(Map.of("Ivanov", "+987456123"));
        phoneBook.add(Map.of("Sidorov", "+789456123"));
        phoneBook.add(Map.of("Petrov", "+654456123"));

        System.out.println(phoneBook.get("Petrov"));
    }
}
