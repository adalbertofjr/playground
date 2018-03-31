package br.com.adalbertofjr.databindingteste;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * MainActivityViewModel
 * Created by Adalberto Fernandes Júnior on 20/12/2017.
 * Copyright © 2016. All rights reserved.
 */

public class MainActivityViewModel extends BaseObservable {

    public static ObservableBoolean isNameError = new ObservableBoolean();
    private static Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;
    }

    public void onClickContinuar(View v) {

        if (isNameError.get()) {
            isNameError.set(false);
        } else {
            isNameError.set(true);
        }

        notifyChange();
    }


    @SuppressLint("RestrictedApi")
    @BindingAdapter("app:addBackgroundTint")
    public static void addBackgroundTint(TextInputEditText view, boolean isError) {
        if (isError) {
            view.setSupportBackgroundTintList(ContextCompat.getColorStateList(context, R.color.orange));
        } else {
            view.setSupportBackgroundTintList(ContextCompat.getColorStateList(context, R.color.colorAccent));
        }
    }

    @BindingAdapter("app:addTextColorHint")
    public static void addTextColorHint(TextInputLayout view, boolean isError) {
        if (isError) {
//            view.setHintTextAppearance(R.style.CustomHintEnabled);
            setInputTextLayoutColor(ContextCompat.getColor(context, R.color.orange), view);
        } else {
//            view.setHintTextAppearance(R.style.CustomHintDisabled);
            setInputTextLayoutColor(ContextCompat.getColor(context, R.color.colorAccent), view);
        }
    }

    @BindingAdapter("app:addTextColor")
    public static void addTextColor(TextView view, boolean isError) {
        if (isError) {
            view.setTextColor(ContextCompat.getColor(context, R.color.orange));
        } else {
            view.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        }
    }

    private static void setInputTextLayoutColor(int color, TextInputLayout textInputLayout) {
        try {
            Field field = textInputLayout.getClass().getDeclaredField("mFocusedTextColor");
            field.setAccessible(true);
            int[][] states = new int[][]{
                    new int[]{}
            };
            int[] colors = new int[]{
                    color
            };
            ColorStateList myList = new ColorStateList(states, colors);
            field.set(textInputLayout, myList);

            Field fDefaultTextColor = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
            fDefaultTextColor.setAccessible(true);
            fDefaultTextColor.set(textInputLayout, myList);

            Method method = textInputLayout.getClass().getDeclaredMethod("updateLabelState", boolean.class);
            method.setAccessible(true);
            method.invoke(textInputLayout, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
