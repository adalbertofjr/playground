package br.com.adalbertofjr.libsestudo.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;

import java.util.List;

import br.com.adalbertofjr.libsestudo.R;
import br.com.adalbertofjr.libsestudo.databinding.ActivityMainBinding;
import br.com.adalbertofjr.libsestudo.http.MoviesSearchTask;
import br.com.adalbertofjr.libsestudo.model.Movie;
import br.com.adalbertofjr.libsestudo.ui.adapter.MoviesAdapter;

public class MoviesActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Movie>>, SearchView.OnQueryTextListener {

    private ActivityMainBinding mBiding;
    private LoaderManager mLoaderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBiding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mLoaderManager = getSupportLoaderManager();
        mLoaderManager.initLoader(0, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public Loader<List<Movie>> onCreateLoader(int id, Bundle args) {
        String q = args != null ? args.getString("q") : null;
        return new MoviesSearchTask(this, q);
    }

    @Override
    public void onLoadFinished(Loader<List<Movie>> loader, List<Movie> data) {
        if (data != null) {
            ListAdapter mAdapter = new MoviesAdapter(this, data);
            mBiding.lvMovies.setAdapter(mAdapter);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Movie>> loader) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Bundle bundle = new Bundle();
        bundle.putString("q", query);
        mLoaderManager.restartLoader(0, bundle, this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
