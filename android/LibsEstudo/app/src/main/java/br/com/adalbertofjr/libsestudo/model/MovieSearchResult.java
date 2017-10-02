package br.com.adalbertofjr.libsestudo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adalb on 29/12/2016.
 */

public class MovieSearchResult {
    @SerializedName("Search")
    public List<Movie> movies;
}
