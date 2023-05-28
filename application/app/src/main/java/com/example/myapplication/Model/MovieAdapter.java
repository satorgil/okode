package com.example.myapplication.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private List<Movie> movies = new ArrayList<>();

    public MovieAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_list_item, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        titleTextView.setText(movie.getTitle());

        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie selectedMovie = getItem(position);

                Intent intent = new Intent(getContext(), MovieDetailActivity.class);
                intent.putExtra("movie_title", selectedMovie.getTitle());
                intent.putExtra("movie_overview", selectedMovie.getOverview());
                intent.putExtra("movie_image", selectedMovie.getPoster_path());
                intent.putExtra("movie_date", selectedMovie.getRelease_date());
                intent.putExtra("movie_language", selectedMovie.getOriginal_language());
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}