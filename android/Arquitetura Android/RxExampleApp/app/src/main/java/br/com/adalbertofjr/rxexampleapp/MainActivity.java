package br.com.adalbertofjr.rxexampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import br.com.adalbertofjr.rxexampleapp.http.TwitchAPI;
import br.com.adalbertofjr.rxexampleapp.http.apimodel.DataGame;
import br.com.adalbertofjr.rxexampleapp.http.apimodel.Twitch;
import br.com.adalbertofjr.rxexampleapp.root.App;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TWITCH_API_KEY = "your_api_key_here";
    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        // Chamada retrofit, serm rxandroid
//        Call<Twitch> twitchCall = twitchAPI.getTopGames("TWITCH_API_KEY");
//
//        twitchCall.enqueue(new Callback<Twitch>() {
//            @Override
//            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
//                List<DataGame> topGames = response.body().getData();
//
//                for (DataGame game : topGames) {
//                    Log.i("Jogo: ", game.getName());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Twitch> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        // Com RXAndroid

        twitchAPI.getTopGamesObservable(TWITCH_API_KEY)
                .flatMap(new Function<Twitch, Observable<DataGame>>() {
                    @Override
                    public Observable<DataGame> apply(Twitch twitch) throws Exception {
                        return Observable.fromIterable(twitch.getData());
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataGame>() {
                    @Override
                    public void accept(DataGame dataGame) throws Exception {
                        System.out.println("From rx java: " + dataGame.getName());
                    }
                });


        twitchAPI.getTopGamesObservable(TWITCH_API_KEY)
                .flatMap(new Function<Twitch, Observable<DataGame>>() {
                    @Override
                    public Observable<DataGame> apply(Twitch twitch) throws Exception {
                        return Observable.fromIterable(twitch.getData());
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataGame -> {
                    System.out.println("From rx java lambda: " + dataGame.getName());
                });
    }
}
