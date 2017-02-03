package com.mbuenoferrer.popularmovies.entities;

public class Movie {
    private final String title;
    private final String poster;

    public Movie(String title, String poster) {
        this.title = title;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }
    public String getPoster() {
        return poster;
    }

}
