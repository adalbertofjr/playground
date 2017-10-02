package br.com.adalbertofjr.libsestudo.http;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import br.com.adalbertofjr.libsestudo.model.Movie;

/**
 * Created by adalb on 29/12/2016.
 */

public class MoviesSearchTask extends AsyncTaskLoader<List<Movie>> {
    private static final String LOG_TAG = MoviesSearchTask.class.getSimpleName();
    private String mQuery;
    private List<Movie> mMovies;

    public MoviesSearchTask(Context context, String mQuery) {
        super(context);
        this.mQuery = mQuery;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if (mQuery == null) return;

        if (mMovies == null) {
            Log.d(LOG_TAG, "forceLoad");
            forceLoad();
        } else {
            Log.d(LOG_TAG, "deliverResult");
            deliverResult(mMovies);
        }
    }

    @Override
    public List<Movie> loadInBackground() {
        try {
            mMovies = MoviesParser.searchByTitle(mQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mMovies;
    }
}
