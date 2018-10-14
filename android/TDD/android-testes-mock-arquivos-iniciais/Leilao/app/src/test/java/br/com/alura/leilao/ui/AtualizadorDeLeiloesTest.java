package br.com.alura.leilao.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

/**
 * AtualizadorDeLeiloesTest
 * Created by Adalberto Fernandes Júnior on 13/10/2018.
 * Copyright © 2018. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class AtualizadorDeLeiloesTest {
    @Mock
    private ListaLeilaoAdapter adapter;

    @Mock
    private LeilaoWebClient client;

    @Mock
    private AtualizadorDeLeiloes.ErroAoCarregaLeilaoListener listener;

    @Test
    public void deve_AtualizarAListaDeLeiloes_QuandoBuscarLeiloesDaApi() {
        AtualizadorDeLeiloes atualizadorDeLeiloes = new AtualizadorDeLeiloes();

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                RespostaListener<List<Leilao>> argument = invocation.getArgument(0);

                argument.sucesso(new ArrayList<Leilao>(Arrays.asList(
                        new Leilao("Console"),
                        new Leilao("Carro")
                )));

                return null;
            }
        }).when(client).todos(ArgumentMatchers.any(RespostaListener.class));

        atualizadorDeLeiloes.buscaLeiloes(adapter, client, listener);

        Mockito.verify(client).todos(ArgumentMatchers.any(RespostaListener.class));
        Mockito.verify(adapter).atualiza(new ArrayList<Leilao>(Arrays.asList(
                new Leilao("Console"),
                new Leilao("Carro")
        )));
    }

    @Test
    public void deve_ApresentarAMensagemDeFalha_QuandoFalharABuscaDeLeiloes() {
        AtualizadorDeLeiloes atualizadorDeLeiloes = new AtualizadorDeLeiloes();

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                RespostaListener<List<Leilao>> argument = invocation.getArgument(0);

                argument.falha(Mockito.anyString());

                return null;
            }
        }).when(client).todos(ArgumentMatchers.any(RespostaListener.class));

        atualizadorDeLeiloes.buscaLeiloes(adapter, client, listener);

        Mockito.verify(listener).erroAoCarregar(Mockito.anyString());

    }
}