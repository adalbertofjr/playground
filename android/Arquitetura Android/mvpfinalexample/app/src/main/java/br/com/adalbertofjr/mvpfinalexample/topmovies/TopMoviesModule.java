package br.com.adalbertofjr.mvpfinalexample.topmovies;

import javax.inject.Singleton;

import br.com.adalbertofjr.mvpfinalexample.http.OmdbApiService;
import br.com.adalbertofjr.mvpfinalexample.http.TMDBApiService;
import dagger.Module;
import dagger.Provides;

/**
 * TopMoviesModule
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */

@Module
public class TopMoviesModule {

    @Provides
    public TopMoviesActivityMVP.Presenter provideTopMoviesActivityPresenter(TopMoviesActivityMVP.Model model) {
        return new TopMoviesPresenter(model);
    }

    @Provides
    public TopMoviesActivityMVP.Model provideTopMoviesActivityModel(Repository repository) {
        return new TopMoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(TMDBApiService movieApiService, OmdbApiService moreInfoApiService) {
        return new TopMoviesRepository(movieApiService, moreInfoApiService);
    }
}
