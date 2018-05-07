package br.com.adalbertofjr.mvpfinalexample.topmovies;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * TopMoviesPresenter
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public class TopMoviesPresenter implements TopMoviesActivityMVP.Presenter {

    private TopMoviesActivityMVP.Model model;
    private TopMoviesActivityMVP.View view;

    private Disposable subscription;

    public TopMoviesPresenter(TopMoviesActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(TopMoviesActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        subscription = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ViewModel>() {
                    @Override
                    public void onNext(ViewModel viewModel) {
                        if (view != null) {
                            view.updateData(viewModel);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                        if (view != null) {
                            view.showSnackBar("Error getting movies");
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void rxUnSubscribe() {
        if (subscription != null) {
            if (!subscription.isDisposed()) {
                subscription.dispose();
            }
        }
    }
}
