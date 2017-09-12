package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static List<Person> getPeople() {
        List<Person> users = new ArrayList<>();
        users.add(new Person("Tim", "Testerman", 1, "test@hascode.com"));
        users.add(new Person("Sara", "Stevens", 20, "dev@hascode.com"));
        users.add(new Person("Mark", "Mustache", 11, "devnull@hascode.com"));
        return users;
    }

    public static List<Car> getCars() {
        List<Car> users = new ArrayList<>();
        users.add(new Car("BMW", "300"));
        users.add(new Car("Audi", "150"));
        return users;
    }
}
