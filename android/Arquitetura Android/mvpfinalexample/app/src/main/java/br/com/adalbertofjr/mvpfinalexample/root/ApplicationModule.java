package br.com.adalbertofjr.mvpfinalexample.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ApplicationModule
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
@Module
public class ApplicationModule {

    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    @Singleton
    @Provides
    public Context provideContext() {
        return application;
    }
}
