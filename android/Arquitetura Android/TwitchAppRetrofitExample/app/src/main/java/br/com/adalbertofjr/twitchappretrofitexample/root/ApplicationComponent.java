package br.com.adalbertofjr.twitchappretrofitexample.root;

import javax.inject.Singleton;

import br.com.adalbertofjr.twitchappretrofitexample.MainActivity;
import br.com.adalbertofjr.twitchappretrofitexample.http.TwitchApiModule;
import dagger.Component;

/**
 * ApplicationComponent
 * Created by Adalberto Fernandes Júnior on 29/04/2018.
 * Copyright © 2018. All rights reserved.
 */

@Singleton
@Component(modules = {ApplicationModule.class, TwitchApiModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
