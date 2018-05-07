package br.com.adalbertofjr.mvpfinalexample.topmovies;

import io.reactivex.Observable;

/**
 * TopMoviesActivityMVP
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface TopMoviesActivityMVP {

    interface View {

        void updateData(ViewModel viewModel);

        void showSnackBar(String s);
    }

    interface Presenter {
        void setView(TopMoviesActivityMVP.View view);

        void loadData();

        void rxUnSubscribe();
    }

    interface Model {
        Observable<ViewModel> result();
    }

}
