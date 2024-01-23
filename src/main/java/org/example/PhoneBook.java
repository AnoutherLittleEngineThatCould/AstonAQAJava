package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final List<Map<String, String>> values = new ArrayList<>();

    public void add(Map<String, String> map) {
        values.add(map);
    }

    public Map<String, List<String>> get(String surname) {
        Map<String, List<String>> phonesBySurname = new HashMap<>();
        List<String> list = new ArrayList<>();
        values.stream().filter(o -> o.containsKey(surname)).forEach((o) -> list.add(o.get(surname)));
        phonesBySurname.put(surname, list);
        return phonesBySurname;
    }


}
