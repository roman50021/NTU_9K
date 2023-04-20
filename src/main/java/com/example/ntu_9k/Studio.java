package com.example.ntu_9k;

public class Studio extends Cinema {
    private int studioId;
    private String name;
    private String country;

    public Studio(){}
    public Studio(int studioId, String name) {
        this.studioId = studioId;
        this.name = name;

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

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
