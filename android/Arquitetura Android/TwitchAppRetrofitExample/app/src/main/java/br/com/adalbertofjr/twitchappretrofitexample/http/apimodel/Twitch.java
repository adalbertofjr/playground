package br.com.adalbertofjr.twitchappretrofitexample.http.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Twitch
 * Created by Adalberto Fernandes Júnior on 29/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public class Twitch {
    @Expose
    @SerializedName("data")
    private List<DataGame> data = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<DataGame> getData() {
        return data;
    }

    public void setData(List<DataGame> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
