package com.mbuenoferrer.popularmovies.data;

import com.mbuenoferrer.popularmovies.entities.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkMovieRepository {

    private Retrofit retrofit;

    public NetworkMovieRepository() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public List<Movie> getPopular() throws IOException {

        TheMovieDBService theMovieDBService = retrofit.create(TheMovieDBService.class);
        Call<MovieListResponse> call = theMovieDBService.getPopular("YOUR_API_KEY"); // todo
        Response<MovieListResponse> movieListResponse = call.execute();
        List<MovieListResult> results = movieListResponse.body().getResults();

        // todo: remove this
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // handle the exception...
            // For example consider calling Thread.currentThread().interrupt(); here.
        }


        return mapResults(results);

        //Asynchronous request
        /*call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {

                //Get our list of articles
                int result = response.body().getPage();
            }
            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t){
                //Handle on Failure here
            }
        });*/
    }

    private List<Movie> mapResults(List<MovieListResult> results){
        List<Movie> movies = new ArrayList<>();

        for(MovieListResult result : results)
        {
            Movie movie = new Movie(result.getTitle(), result.getPosterPath());
            movies.add(movie);
        }

        return movies;
    }
}
