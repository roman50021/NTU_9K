package com.example.ntu_9k;

public class Session extends Cinema{
    private int sessionId;
    private int movieId;
    private int visitorsId;

    public Session(){}

    public Session(int sessionId, int movieId, int visitorsId) {
        this.sessionId = sessionId;
        this.movieId = movieId;
        this.visitorsId =visitorsId;
    }

    // Геттеры и сеттеры для полей

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getVisitorsId() {
        return visitorsId;
    }

    public void setVisitorsId(int visitorsId) {
        this.visitorsId = visitorsId;
    }
}
