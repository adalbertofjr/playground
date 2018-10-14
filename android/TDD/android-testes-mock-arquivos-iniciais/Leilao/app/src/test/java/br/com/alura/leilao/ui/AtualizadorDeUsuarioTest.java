package br.com.alura.leilao.ui;

import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.alura.leilao.database.dao.UsuarioDAO;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaUsuarioAdapter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * AtualizadorDeUsuarioTest
 * Created by Adalberto Fernandes Júnior on 13/10/2018.
 * Copyright © 2018. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class AtualizadorDeUsuarioTest {

    @Mock
    private UsuarioDAO dao;
    @Mock
    private ListaUsuarioAdapter adapter;
    @Mock
    private RecyclerView recyclerView;

    @Test
    public void deve_AtualizarListaDeUsuario_QuandoSalvarUsuario() {
        AtualizadorDeUsuario atualizadorDeUsuario = new AtualizadorDeUsuario(
                dao,
                adapter,
                recyclerView);

        Usuario usuario = new Usuario("Hal");
        when(dao.salva(usuario)).thenReturn( new Usuario(1,"Hal") );
        when(adapter.getItemCount()).thenReturn(1);
        atualizadorDeUsuario.salva(usuario);

        verify(dao).salva(new Usuario("Hal"));
        verify(adapter).adiciona(new Usuario(1,"Hal"));
        verify(recyclerView).smoothScrollToPosition(0);


    }
}