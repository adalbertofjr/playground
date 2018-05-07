package br.com.adalbertofjr.mvpfinalexample.topmovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.adalbertofjr.mvpfinalexample.R;
import br.com.adalbertofjr.mvpfinalexample.root.App;
import br.com.adalbertofjr.mvpfinalexample.util.DividerItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TopMoviesActivity
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
public class TopMoviesActivity extends AppCompatActivity implements TopMoviesActivityMVP.View {

    @BindView(R.id.rv_top_movies)
    RecyclerView recyclerView;

    @BindView(R.id.ll_root_view)
    View rootView;

    @Inject
    TopMoviesActivityMVP.Presenter presenter;

    ListTopMoviesAdapter listTopMoviesAdapter;
    private ArrayList<ViewModel> resultList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_top_movies);

        ((App) getApplication()).getComponent().inject(this); // injetando dependência

        ButterKnife.bind(this);

        resultList = new ArrayList<>();
        listTopMoviesAdapter = new ListTopMoviesAdapter(resultList);

        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listTopMoviesAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnSubscribe();
        resultList.clear();
        listTopMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        listTopMoviesAdapter.notifyItemChanged(resultList.size() - 1);
    }

    @Override
    public void showSnackBar(String s) {
        Snackbar.make(rootView, s, Snackbar.LENGTH_SHORT).show();
    }
}
