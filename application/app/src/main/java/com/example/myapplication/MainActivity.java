package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;


import com.example.myapplication.ApiService.ApiService;
import com.example.myapplication.Model.MovieAdapter;
import com.example.myapplication.Model.MovieResponse;
import com.example.myapplication.Model.Movie;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "2cfb22fa4ed9ce77d2efcb2d765580bc";

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        Call<MovieResponse> call = apiService.getPopularMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    EditText editText = findViewById(R.id.editText);
                    String searchTerm = " ";

                    editText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            String searchTerm = s.toString();
                            List<Movie> movies = movieResponse.getMovies();

                            List<Movie> filteredMovies = new ArrayList<>();
                            for (Movie movie : movies) {
                                if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                                    filteredMovies.add(movie);
                                }
                            }
                            ListView listView = findViewById(R.id.listView);
                            MovieAdapter adapter = new MovieAdapter(MainActivity.this, filteredMovies);
                            listView.setAdapter(adapter);
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                    List<Movie> movies = movieResponse.getMovies();


                    ListView listView = findViewById(R.id.listView);
                    MovieAdapter adapter = new MovieAdapter(MainActivity.this, movies);
                    listView.setAdapter(adapter);
                } else {
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
            }
        });
    }
}
