package br.com.adalbertofjr.rxexampleapp.http;

import br.com.adalbertofjr.rxexampleapp.http.apimodel.Twitch;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * TwitchAPI
 * Created by Adalberto Fernandes Júnior on 29/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface TwitchAPI {

    @GET("games/top")
    Call<Twitch> getTopGames(@Header("Client-ID") String clientID);

    @GET("games/top")
    Observable<Twitch> getTopGamesObservable(@Header("Client-ID") String clientID);
}
