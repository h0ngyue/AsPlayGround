package com.kikyo.asplayground;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuailongcheng on 13/02/2017.
 */

public class Person {

    private int id;

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Person person) {
        return person.id == id;
    }

    public int hashCode() {
        return id;
    }
}