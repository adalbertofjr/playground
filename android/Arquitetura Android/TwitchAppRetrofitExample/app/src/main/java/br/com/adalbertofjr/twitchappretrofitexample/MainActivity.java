package br.com.adalbertofjr.twitchappretrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import br.com.adalbertofjr.twitchappretrofitexample.http.TwitchAPI;
import br.com.adalbertofjr.twitchappretrofitexample.http.apimodel.DataGame;
import br.com.adalbertofjr.twitchappretrofitexample.http.apimodel.Twitch;
import br.com.adalbertofjr.twitchappretrofitexample.root.App;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        Call<Twitch> twitchCall = twitchAPI.getTopGames("key_twitch_api");

        twitchCall.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<DataGame> topGames = response.body().getData();

                for (DataGame game : topGames) {
                    Log.i("Jogo: ", game.getName());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
