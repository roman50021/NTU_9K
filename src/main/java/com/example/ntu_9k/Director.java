package com.example.ntu_9k;

public class Director {
    private int directorId;
    private String name;
    private int age;
    private String gender;

    public Director(int directorId, String name, int age, String gender) {
        this.directorId = directorId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getDirectorId() {
        return directorId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
