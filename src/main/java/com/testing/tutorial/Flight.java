package com.testing.tutorial;

public class Flight {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Flight(String name) {
        setName(name);
    }
}
