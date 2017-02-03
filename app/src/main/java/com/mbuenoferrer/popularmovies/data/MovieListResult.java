package com.mbuenoferrer.popularmovies.data;

import com.google.gson.annotations.SerializedName;

public class MovieListResult {

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private double voteAverage;


    public String getTitle() {
        return title;
    }
    public String getPosterPath() {
        return "http://image.tmdb.org/t/p/w500" + posterPath;
    }
    public String getOverview() {
        return overview;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public double getVoteAverage() {
        return voteAverage;
    }
}
