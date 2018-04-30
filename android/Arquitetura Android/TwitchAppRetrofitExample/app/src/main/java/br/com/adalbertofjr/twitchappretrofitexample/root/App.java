package br.com.adalbertofjr.twitchappretrofitexample.root;

import android.app.Application;

import br.com.adalbertofjr.twitchappretrofitexample.http.TwitchApiModule;

/**
 * App
 * Created by Adalberto Fernandes Júnior on 29/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public class App extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .twitchApiModule(new TwitchApiModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
