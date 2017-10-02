package br.com.adalbertofjr.libsestudo.http;

import br.com.adalbertofjr.libsestudo.model.MovieSearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adalb on 29/12/2016.
 */

public interface MoviesRetrofit {
    @GET("./")
    Call<MovieSearchResult> search(@Query("s") String q, @Query("r") String format);
}

