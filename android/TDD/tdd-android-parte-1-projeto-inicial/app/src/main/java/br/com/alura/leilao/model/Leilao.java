package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.leilao.exception.LanceMenorQueMaiorLanceException;
import br.com.alura.leilao.exception.LanceRealizadoIgualAoUltimoUsuarioException;
import br.com.alura.leilao.exception.UsuarioJaRealizouCincoLancesException;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = 0.0;
    private double menorLance = 0.0;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }


    public void propoe(Lance lance) {
        valida(lance);
        lances.add(lance);
        double valorLance = lance.getValor();
        if (defineValorMaiorEMenorParaOPrimeiroLance(valorLance)) return;
        Collections.sort(lances);
        calculaMaiorLance(valorLance);
    }

    private boolean defineValorMaiorEMenorParaOPrimeiroLance(double valorLance) {
        if (lances.size() == 1) {
            maiorLance = valorLance;
            menorLance = valorLance;

            return true;
        }
        return false;
    }

    private void valida(Lance lance) {
        double valorLance = lance.getValor();

        if (lanceMenorQueUltimoLance(valorLance))
            throw new LanceMenorQueMaiorLanceException();

        if (possuiLances()) {
            Usuario usuarioNovo = lance.getUsuario();

            if (usuarioIgualAoUltimoLance(usuarioNovo))
                throw new LanceRealizadoIgualAoUltimoUsuarioException();

            if (usuarioComCincoLances(usuarioNovo))
                throw new UsuarioJaRealizouCincoLancesException();
        }
    }

    private boolean possuiLances() {
        return !lances.isEmpty();
    }

    private boolean usuarioComCincoLances(Usuario usuarioNovo) {
        int quatidadeLancesDoUsuario = 0;
        for (Lance l : lances) {
            Usuario usuarioExistente = l.getUsuario();

            if (usuarioExistente.equals(usuarioNovo)) {
                quatidadeLancesDoUsuario++;

                if (quatidadeLancesDoUsuario == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean usuarioIgualAoUltimoLance(Usuario usuarioNovo) {
        Usuario ultimoUsuario = lances.get(0).getUsuario();
        if (usuarioNovo.equals(ultimoUsuario)) {
            return true;
        }
        return false;
    }

    private boolean lanceMenorQueUltimoLance(double valorLance) {
        if (maiorLance > valorLance) {
            return true;
        }
        return false;
    }

    private void calculaMenorLance(double valorLance) {
        if (valorLance < menorLance) {
            menorLance = valorLance;
        }
    }

    private void calculaMaiorLance(double valorLance) {
        if (valorLance > maiorLance) {
            maiorLance = valorLance;
        }
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public List<Lance> getTresMaioresLances() {
        int quantidadeMaximaDeLances = lances.size();

        if (quantidadeMaximaDeLances > 3) {
            quantidadeMaximaDeLances = 3;
        }

        return lances.subList(0, quantidadeMaximaDeLances);
    }

    public int getQuantidadeLances() {
        return lances.size();
    }
}
