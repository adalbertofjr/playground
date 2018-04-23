package br.com.adalbertofjr.loginmvpexample.root;

import javax.inject.Singleton;

import br.com.adalbertofjr.loginmvpexample.login.LoginActivity;
import br.com.adalbertofjr.loginmvpexample.login.LoginModule;
import dagger.Component;

/**
 * ApplicationComponent
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
