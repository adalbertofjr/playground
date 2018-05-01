package br.com.adalbertofjr.rxexampleapp.root;

import android.app.Application;

import br.com.adalbertofjr.rxexampleapp.http.TwitchApiModule;

/**
 * App
 * Created by Adalberto Fernandes Júnior on 01/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public class App extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .twitchApiModule(new TwitchApiModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
