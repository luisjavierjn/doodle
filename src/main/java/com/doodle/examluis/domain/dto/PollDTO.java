package com.doodle.examluis.domain.dto;

import java.io.Serializable;

public class PollDTO implements Serializable {

    private static final long serialVersionUID = 1717118003848939112L;

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
