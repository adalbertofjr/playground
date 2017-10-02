package br.com.adalbertofjr.libsestudo.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * LibsEstudo
 * ImageBinding
 * <p>
 * Created by Adalberto Fernandes Júnior on 26/12/2016.
 * Copyright © 2016 - Adalberto Fernandes Júnior. All rights reserved.
 */


public class ImageBinding {
    @BindingAdapter({"android:src"})
    public static void setImage(ImageView imageView, String url){
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
