package com.example.ntu_9k;

public class Studio {
    private int studioId;
    private String name;
    private String country;

    public Studio(int studioId, String name, String country) {
        this.studioId = studioId;
        this.name = name;
        this.country = country;
    }

    public int getStudioId() {
        return studioId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
