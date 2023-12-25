package org.example;

import java.util.Arrays;

/**
 * Lesson 4 Levin Vladimir
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Task 1-2 : ");
        Person IvanIvanov = new Person("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        Person PetrSidorov = new Person("Petr Sidorov", "Manager",
                "ptpetrov@mailbox.com", "893211223", 33000, 27);
        Person AnnaKarenina = new Person("Anna Karenina", "Lawyer",
                "annkaren@mailbox.com", "832912213", 15000, 23);
        Person SidorPetrov = new Person("Sidor Petrov", "SEO",
                "sipet@mailbox.com", "829312321", 30000, 32);
        Person RomanEgorov = new Person("RomanEgorov", "HR",
                "rmego@mailbox.com", "892123312", 25000, 22);

        Person[] employee = new Person[5];

        employee[0] = IvanIvanov;
        employee[1] = PetrSidorov;
        employee[2] = AnnaKarenina;
        employee[3] = SidorPetrov;
        employee[4] = RomanEgorov;

        System.out.println(Arrays.toString(employee));

        System.out.println("Task 3 : ");

        Park.Amusement rollerCoaster = new Park.Amusement("Roller coaster", "11-18", 200);
        Park.Amusement railway = new Park.Amusement("Railway", "10-19", 100);
        Park.Amusement carousel = new Park.Amusement("Сarousel", "9-16", 100);
        Park.Amusement trampoline = new Park.Amusement("Trampoline", "11-17", 150);

        Park park = new Park();
        park.parkAmusement.add(rollerCoaster);
        park.parkAmusement.add(railway);
        park.parkAmusement.add(carousel);
        park.parkAmusement.add(trampoline);

        System.out.println(park);

    }
}