package br.com.adalbertofjr.loginmvpexample.login;

/**
 * LoginActivityMVP
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface LoginActivityMVP {

    interface View { //contrato da activity

        String getFirstName();

        String getLastName();

        void setFirstName(String fname);

        void setLastName(String lname);

        void showInputError();

        void showUserSavedMessage();

    }

    interface Presenter { // tem relação com a view e a model, regras do negócio

        void setView(LoginActivityMVP.View view); // referência da view

        void loginButtonClicked(); // evento de click de log in

        void getCurrentUser(); // busca na model o usuário atual
    }

    interface Model {
        void createUser(String name, String lastName); // salva dados do usuário

        User getUser(); // rucupera o usuario
    }
}
