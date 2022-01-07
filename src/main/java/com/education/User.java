package com.education;

public class User {
    private int id;
    private String name;
    private String email;

    private static int counter = 1;

    public User() {
        this.id = counter++;
    }

    public User(String name, String email) {
        this.id = counter++;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }
}
