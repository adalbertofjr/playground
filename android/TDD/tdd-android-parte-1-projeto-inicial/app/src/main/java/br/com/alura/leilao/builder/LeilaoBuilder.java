package br.com.alura.leilao.builder;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

/**
 * LeilaoBuilder
 * Created by Adalberto Fernandes Júnior on 12/10/2018.
 * Copyright © 2018. All rights reserved.
 */
public class LeilaoBuilder {

    private final Leilao leilao;

    public LeilaoBuilder(String descricao) {
        this.leilao = new Leilao(descricao);
    }

    public LeilaoBuilder lance(Usuario usuario, double valor) {
        this.leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao build() {
        return leilao;
    }
}
