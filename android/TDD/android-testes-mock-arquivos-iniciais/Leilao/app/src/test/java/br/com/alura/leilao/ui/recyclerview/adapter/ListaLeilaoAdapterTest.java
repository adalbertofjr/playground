package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.leilao.model.Leilao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * ListaLeilaoAdapterTest
 * Created by Adalberto Fernandes Júnior on 13/10/2018.
 * Copyright © 2018. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListaLeilaoAdapterTest {

    @Mock
    private Context context;

    @Spy
    ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(context);

    @Test
    public void deve_AtualizarAListaDeLeiloes_QuandoRecebeListaDeLeiloes() {
        Mockito.doNothing().when(adapter).atualizarAdapter();

        adapter.atualiza(new ArrayList<Leilao>(Arrays.asList(
                new Leilao("Console"),
                new Leilao("Fusca 1970")
        )));

        int quantidadeLeiloesDevolvido = adapter.getItemCount();

        Mockito.verify(adapter).atualizarAdapter();

        assertThat(quantidadeLeiloesDevolvido, is(2));
    }
}