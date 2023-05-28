package com.example.myapplication.ApiService;

import com.example.myapplication.Model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyY2ZiMjJmYTRlZDljZTc3ZDJlZmNiMmQ3NjU1ODBiYyIsInN1YiI6IjY0NzEzNTYyOWFlNjEzMDEyNTdiNjY0MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.rEoOCq7Ht5hgdV-ibKUvcA6XhIj-n74_G7sLReXMV1I")
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);
}
