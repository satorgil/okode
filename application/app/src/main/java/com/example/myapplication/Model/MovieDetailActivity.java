package com.example.myapplication.Model;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView overviewTextView;
    private TextView dateTextView;
    private TextView languageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        titleTextView = findViewById(R.id.titleTextView);
        overviewTextView = findViewById(R.id.overviewTextView);
        dateTextView = findViewById(R.id.dateTextView);
        languageTextView = findViewById(R.id.languageTextView);

        Intent intent = getIntent();
        String movieTitle = intent.getStringExtra("movie_title");
        String movieOverview = intent.getStringExtra("movie_overview");
        String movieImage = intent.getStringExtra("movie_image");
        String movieDate = intent.getStringExtra("movie_date");
        String movieLanguage = intent.getStringExtra("movie_language");

        titleTextView.setText(movieTitle);
        overviewTextView.setText(movieOverview);
        dateTextView.setText(movieDate);
        languageTextView.setText(movieLanguage);
        ImageView moviePosterImageView = findViewById(R.id.moviePosterImageView);
        String imageUrl = "https://image.tmdb.org/t/p/w200/" + movieImage; // Asegúrate de tener el objeto "movie" con la información de la película
        Log.d("main", imageUrl);

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_loading_background) // Imagen de carga mientras se carga la imagen real
                .into(moviePosterImageView);

    }
}

