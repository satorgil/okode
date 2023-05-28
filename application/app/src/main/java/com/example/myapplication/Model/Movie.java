package com.example.myapplication.Model;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("poster_path")
    private String poster_path;

    public String getTitle() {
        return title;
    }
    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }
    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

}

