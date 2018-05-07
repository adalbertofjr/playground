package br.com.adalbertofjr.mvpfinalexample.http;


import br.com.adalbertofjr.mvpfinalexample.http.apimodel.TopRated;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * TMDBApiService
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface TMDBApiService {

    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);
}
