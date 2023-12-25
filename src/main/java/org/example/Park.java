package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    List<Amusement> parkAmusement = new ArrayList<>();
    public void addAmusement(Amusement amusement){
        parkAmusement.add(amusement);
    }
    public static class Amusement {
        private String name;
        private String workingHours;
        private int ticketPrice;

        public Amusement(String name, String workingHours, int ticketPrice) {
            this.name = name;
            this.workingHours = workingHours;
            this.ticketPrice = ticketPrice;
        }

        @Override
        public String toString() {
            return "Amusement{" +
                    "name='" + name + '\'' +
                    ", workingHours='" + workingHours + '\'' +
                    ", ticketPrice=" + ticketPrice +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkAmusement=" + parkAmusement +
                '}';
    }
}
