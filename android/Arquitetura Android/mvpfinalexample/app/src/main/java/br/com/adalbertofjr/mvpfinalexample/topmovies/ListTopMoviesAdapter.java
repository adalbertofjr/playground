package br.com.adalbertofjr.mvpfinalexample.topmovies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.adalbertofjr.mvpfinalexample.R;

/**
 * ListTopMoviesAdapter
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
class ListTopMoviesAdapter extends RecyclerView.Adapter<ListTopMoviesAdapter.ListItemViewHolder> {

    private List<ViewModel> list;

    public ListTopMoviesAdapter(List<ViewModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);

        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.country.setText(list.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView country;

        public ListItemViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txv_name);
            country = itemView.findViewById(R.id.txv_country);
        }
    }
}
