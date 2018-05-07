package br.com.adalbertofjr.mvpfinalexample.topmovies;

import br.com.adalbertofjr.mvpfinalexample.http.apimodel.Result;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

/**
 * TopMoviesModel
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public class TopMoviesModel implements TopMoviesActivityMVP.Model {
    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(
                repository.getResultData(),
                repository.getCountryData(),
                new BiFunction<Result, String, ViewModel>() {
                    @Override
                    public ViewModel apply(Result result, String s) throws Exception {
                        return new ViewModel(result.getTitle(), s);
                    }
                }
        );
    }
}
