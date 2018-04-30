package br.com.adalbertofjr.twitchappretrofitexample.http.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Pagination
 * Created by Adalberto Fernandes Júnior on 29/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public class Pagination {
    @SerializedName("cursor")
    @Expose
    private String cursor;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
