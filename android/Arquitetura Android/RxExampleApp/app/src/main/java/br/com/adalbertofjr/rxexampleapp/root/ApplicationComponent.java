package br.com.adalbertofjr.rxexampleapp.root;

import javax.inject.Singleton;

import br.com.adalbertofjr.rxexampleapp.MainActivity;
import br.com.adalbertofjr.rxexampleapp.http.TwitchApiModule;
import dagger.Component;

/**
 * ApplicationComponent
 * Created by Adalberto Fernandes Júnior on 01/05/2018.
 * Copyright © 2018. All rights reserved.
 */

@Singleton
@Component(modules = {ApplicationModule.class, TwitchApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);
}
