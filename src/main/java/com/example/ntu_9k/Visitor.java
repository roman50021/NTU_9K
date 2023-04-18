package com.example.ntu_9k;

public class Visitor {
    private int visitorsId;
    private String firstName;
    private String lastName;
    private int sessionId;

    // Геттеры и сеттеры для полей

    public int getVisitorsId() {
        return visitorsId;
    }

    public void setVisitorsId(int visitorsId) {
        this.visitorsId = visitorsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}
