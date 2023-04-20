package com.example.ntu_9k;

public class Director extends Cinema{
    private int directorId;
    private String first_name;
    private String last_name;

    public Director(){}

    public Director(int directorId, String first_name, String last_name) {
        this.directorId = directorId;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
