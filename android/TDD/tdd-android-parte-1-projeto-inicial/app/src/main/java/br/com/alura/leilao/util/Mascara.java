package br.com.alura.leilao.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Mascara
 * Created by Adalberto Fernandes Júnior on 13/10/2018.
 * Copyright © 2018. All rights reserved.
 */
public class Mascara {


    public static String formatarMoeda(double valor) {
        Locale ptBr = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBr);


        return numberFormat.format(valor);
    }
}
