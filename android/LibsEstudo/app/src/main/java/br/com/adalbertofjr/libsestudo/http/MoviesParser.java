package br.com.adalbertofjr.libsestudo.http;

import java.io.IOException;
import java.util.List;

import br.com.adalbertofjr.libsestudo.model.Movie;
import br.com.adalbertofjr.libsestudo.model.MovieSearchResult;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adalb on 29/12/2016.
 */

public class MoviesParser {

    public static List<Movie> searchByTitle(String q) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MoviesRetrofit api = retrofit.create(MoviesRetrofit.class);

        MovieSearchResult result = api.search(q, "json").execute().body();

        if (result != null) {
            return result.movies;
        }

        return null;
    }
}
