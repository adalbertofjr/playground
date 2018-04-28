package br.com.adalbertofjr.loginmvpexample;

import org.junit.Before;
import org.junit.Test;

import br.com.adalbertofjr.loginmvpexample.login.LoginActivityMVP;
import br.com.adalbertofjr.loginmvpexample.login.LoginActivityPresenter;
import br.com.adalbertofjr.loginmvpexample.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * PresenterTests
 * Created by Adalberto Fernandes Júnior on 28/04/2018.
 * Copyright © 2018. All rights reserved.
 */
public class PresenterTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockLoginView;
    LoginActivityPresenter presenter;
    User user;


    @Before
    public void setup(){

        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("Adalberto", "Fernandes Junior");

        //when(mockLoginModel.getUser()).thenReturn(user);

        mockLoginView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockLoginView);

    }


    // Verifica se não ocorreu interações com a view
//    @Test
//    public void noInteractionWithView(){
//
//        presenter.getCurrentUser();
//
//        verifyZeroInteractions(mockLoginView);
//    }


    // Veririca quando possui usuário válido
    @Test
    public void loadTheUserRespositoryWhenValidUserIsPresent(){
        when(mockLoginModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        // verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        // verify view interactions
        verify(mockLoginView, times(1)).setFirstName("Adalberto");
        verify(mockLoginView, times(1)).setLastName("Fernandes Junior");
        verify(mockLoginView, never()).showUserNotAvailable();
    }


    // Verifica se mostra mensagem de usuário indisponivel quando não há usuário
    @Test
    public void shouldShowErrorMessageWhenUserIsNull(){
        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        // verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        // verify view interactions
        verify(mockLoginView, never()).setFirstName("Adalberto");
        verify(mockLoginView, never()).setLastName("Fernandes Junior");
        verify(mockLoginView, times(1)).showUserNotAvailable();
    }


    @Test
    public void shouldCreateErrorMessageIfFieldAreEmpty(){
        when(mockLoginView.getFirstName()).thenReturn(""); // nome vazio

        presenter.saveUser(); // salva

        verify(mockLoginView, times(1)).getFirstName(); // check se executou 1 vez
        verify(mockLoginView, never()).getLastName(); // check se nunca executou
        verify(mockLoginView, times(1)).showInputError(); // check se mostrou msg uma vez

        when(mockLoginView.getFirstName()).thenReturn("Adalberto");
        when(mockLoginView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockLoginView, times(2)).getFirstName();
        verify(mockLoginView, times(1)).getLastName();
        verify(mockLoginView, times(2)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveValidUser(){
        when(mockLoginView.getFirstName()).thenReturn("Adalberto"); // 1 vez
        when(mockLoginView.getLastName()).thenReturn("Fernandes"); // 1 vez

        presenter.saveUser(); // 2 vezes getFirstName, getLastName

        verify(mockLoginView, times(2)).getFirstName();
        verify(mockLoginView, times(2)).getLastName();

        verify(mockLoginModel, times(1)).createUser("Adalberto", "Fernandes");

        verify(mockLoginView, times(1)).showUserSavedMessage();
    }




}
