package com.example.ntu_9k;

public class Session {
    private int sessionId;
    private int movieId;
    private int visitorsId;

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
