package br.com.adalbertofjr.mvpfinalexample.root;

import android.app.Application;

import br.com.adalbertofjr.mvpfinalexample.http.OmdbApiModule;
import br.com.adalbertofjr.mvpfinalexample.http.TMDBApiModule;
import br.com.adalbertofjr.mvpfinalexample.topmovies.TopMoviesModule;

/**
 * App
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .topMoviesModule(new TopMoviesModule())
                .tMDBApiModule(new TMDBApiModule())
                .omdbApiModule(new OmdbApiModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
