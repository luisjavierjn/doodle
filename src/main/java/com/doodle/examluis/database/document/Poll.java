package com.doodle.examluis.database.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "polls")
public class Poll {

    String name;
    int age;
    String car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
