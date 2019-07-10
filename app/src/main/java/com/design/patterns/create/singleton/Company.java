package com.design.patterns.create.singleton;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void meeting() {
        for (Person person : personList) {
            person.talk();
        }
    }

}
