package br.com.adalbertofjr.mvpfinalexample.topmovies;

import br.com.adalbertofjr.mvpfinalexample.http.apimodel.Result;
import io.reactivex.Observable;

/**
 * Repository
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();
}
