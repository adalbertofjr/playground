package br.com.adalbertofjr.loginmvpexample.login;

import android.support.annotation.Nullable;

/**
 * LoginActivityPresenter
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model; // para salvar dados do usuário

    public LoginActivityPresenter(LoginActivityMVP.Model model) { //inserido por injection com dagger
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {

        if(view != null){
            if(view.getFirstName().trim().equals("") || view.getLastName().trim().equals("") ){
                view.showInputError();
            }else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user != null) {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }else {
            view.showUserNotAvailable();
        }
    }

    @Override
    public void saveUser() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {

                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();

            }
        }
    }
}
