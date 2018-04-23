package br.com.adalbertofjr.loginmvpexample.login;

/**
 * LoginModel
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public class LoginModel implements LoginActivityMVP.Model {
    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String name, String lastName) {
        repository.saveUser(new User(name, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
