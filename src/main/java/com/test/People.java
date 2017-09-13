package com.test;

import java.util.List;

public class People {

//либо если нужно, то ставим аннотацию @JsonName("person")

    private List<Person> person;

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

}
