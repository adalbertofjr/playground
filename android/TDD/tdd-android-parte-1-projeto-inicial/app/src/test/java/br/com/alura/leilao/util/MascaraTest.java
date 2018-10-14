package br.com.alura.leilao.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * MascaraTest
 * Created by Adalberto Fernandes Júnior on 13/10/2018.
 * Copyright © 2018. All rights reserved.
 */
public class MascaraTest {

    @Test
    public void deve_RetornarValorEmReais_QuandoApresentarValor() {
        String valorFormatadoDevolvido = Mascara.formatarMoeda(250.00);

        assertThat(valorFormatadoDevolvido, is(equalTo("R$ 250,00")));
    }
}