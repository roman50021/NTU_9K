package com.example.ntu_9k;

public class Session extends Cinema{
    private int sessionId;
    private int movieid;


    public Session(){}

    public Session(int sessionId, int movieid) {
        this.sessionId = sessionId;
        this.movieid = movieid;

    }

    // Геттеры и сеттеры для полей

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getMovieId() {
        return movieid;
    }

    public void setMovieId(int movieId) {
        this.movieid = movieId;
    }


}
