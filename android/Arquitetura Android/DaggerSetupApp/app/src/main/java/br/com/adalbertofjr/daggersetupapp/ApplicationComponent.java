package br.com.adalbertofjr.daggersetupapp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ApplicationComponent
 * Created by Adalberto Fernandes Júnior on 21/04/2018.
 * Copyright © 2018. All rights reserved.
 *
 * 2˚ - Criando o componente
 *
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target); // classe que pode ser utilizada pelo componente.
}
