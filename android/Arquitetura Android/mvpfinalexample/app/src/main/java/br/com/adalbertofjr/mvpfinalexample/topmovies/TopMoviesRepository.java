package br.com.adalbertofjr.mvpfinalexample.topmovies;

import java.util.ArrayList;
import java.util.List;

import br.com.adalbertofjr.mvpfinalexample.http.OmdbApiService;
import br.com.adalbertofjr.mvpfinalexample.http.TMDBApiService;
import br.com.adalbertofjr.mvpfinalexample.http.apimodel.OmdbApi;
import br.com.adalbertofjr.mvpfinalexample.http.apimodel.Result;
import br.com.adalbertofjr.mvpfinalexample.http.apimodel.TopRated;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * TopMoviesRepository
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
class TopMoviesRepository implements Repository {
    private TMDBApiService movieApiService;
    private OmdbApiService moreInfoApiService;
    private long timestamp;
    private List<String> countries;
    private List<Result> results;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds

    public TopMoviesRepository(TMDBApiService movieApiService, OmdbApiService moreInfoApiService) {
        this.movieApiService = movieApiService;
        this.moreInfoApiService = moreInfoApiService;
        this.timestamp = System.currentTimeMillis();
        this.countries = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory() {
        if (isUpToDate()) {
            return Observable.fromIterable(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultsFromNetwork() {

        Observable<TopRated> topRatedObservable = movieApiService.getTopRatedMovies(1).concatWith(movieApiService.getTopRatedMovies(2)).concatWith(movieApiService.getTopRatedMovies(3));

        return topRatedObservable.concatMap(new Function<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> apply(TopRated topRated) {
                return Observable.fromIterable(topRated.getResults());
            }
        }).doOnNext(new Consumer<Result>() {
            @Override
            public void accept(Result result) {
                results.add(result);
            }
        });
    }

    @Override
    public Observable<String> getCountriesFromMemory() {
        if (isUpToDate()) {
            return Observable.fromIterable(countries);
        } else {
            timestamp = System.currentTimeMillis();
            countries.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<String> getCountriesFromNetwork() {
        return getResultsFromNetwork().concatMap(new Function<Result, Observable<OmdbApi>>() {
            @Override
            public Observable<OmdbApi> apply(Result result) {
                return moreInfoApiService.getCountry(result.getTitle());
            }
        }).concatMap(new Function<OmdbApi, Observable<String>>() {
            @Override
            public Observable<String> apply(OmdbApi omdbApi) {
                return Observable.just(omdbApi.getCountry());
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) {
                countries.add(s);
            }
        });
    }

    @Override
    public Observable<String> getCountryData() {
        return getCountriesFromMemory().switchIfEmpty(getCountriesFromNetwork());
    }

    @Override
    public Observable<Result> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }
}
