package org.example;

public class Person {
    private String name;
    private String jobTitle;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String jobTitle, String email, String phone, int salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
