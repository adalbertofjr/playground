package br.com.adalbertofjr.mvpfinalexample.http;

import br.com.adalbertofjr.mvpfinalexample.http.apimodel.OmdbApi;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * OmdbApiService
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface OmdbApiService {
    @GET("/")
    Observable<OmdbApi> getCountry(@Query("t") String title);

}
