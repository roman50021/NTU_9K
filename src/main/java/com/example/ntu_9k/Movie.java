package com.example.ntu_9k;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Cinema {
    private int movieId;
    private String title;
    private int releaseYear;
    private int directorId;
    private int studioId;

    public Movie(){}

    public Movie(int id, String title, int releaseYear, int directorId, int studioId) {
        this.movieId = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.directorId = directorId;
        this.studioId = studioId;
    }
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public List<Movie> getAllMovies() {

        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
        ) {
            List<Movie> movies = new ArrayList<>();

            while (rs.next()) {
                Movie movie = extractMovieFromResultSet(rs);
                movies.add(movie);
            }

            return movies;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private Movie extractMovieFromResultSet(ResultSet rs)throws SQLException{
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setReleaseYear(rs.getInt("release_year"));
        movie.setDirectorId(rs.getInt("director_id"));
        movie.setStudioId(rs.getInt("studio_id"));
        return movie;
    }
}