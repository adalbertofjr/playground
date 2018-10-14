package br.com.alura.leilao.ui;

import java.util.List;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

/**
 * AtualizadorDeLeiloes
 * Created by Adalberto Fernandes Júnior on 13/10/2018.
 * Copyright © 2018. All rights reserved.
 */
public class AtualizadorDeLeiloes {

    public void buscaLeiloes(final ListaLeilaoAdapter adapter, LeilaoWebClient client, final ErroAoCarregaLeilaoListener listener) {
        client.todos(new RespostaListener<List<Leilao>>() {
            @Override
            public void sucesso(List<Leilao> leiloes) {
                adapter.atualiza(leiloes);
            }

            @Override
            public void falha(String mensagem) {
                listener.erroAoCarregar(mensagem);
            }
        });
    }

    public interface ErroAoCarregaLeilaoListener {
        void erroAoCarregar(String mensagem);
    }
}
