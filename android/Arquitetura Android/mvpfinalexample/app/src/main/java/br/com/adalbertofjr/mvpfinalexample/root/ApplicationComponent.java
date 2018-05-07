package br.com.adalbertofjr.mvpfinalexample.root;

import javax.inject.Singleton;

import br.com.adalbertofjr.mvpfinalexample.http.OmdbApiModule;
import br.com.adalbertofjr.mvpfinalexample.http.TMDBApiModule;
import br.com.adalbertofjr.mvpfinalexample.topmovies.TopMoviesActivity;
import br.com.adalbertofjr.mvpfinalexample.topmovies.TopMoviesModule;
import dagger.Component;

/**
 * ApplicationComponent
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
@Singleton
@Component(modules = {ApplicationModule.class, TopMoviesModule.class, TMDBApiModule.class, OmdbApiModule.class})
public interface ApplicationComponent {
    void inject(TopMoviesActivity target);
}
