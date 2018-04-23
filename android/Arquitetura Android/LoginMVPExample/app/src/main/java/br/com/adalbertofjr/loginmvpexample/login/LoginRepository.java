package br.com.adalbertofjr.loginmvpexample.login;

/**
 * LoginRepository
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public interface LoginRepository {
    User getUser();

    void saveUser(User user);
}
