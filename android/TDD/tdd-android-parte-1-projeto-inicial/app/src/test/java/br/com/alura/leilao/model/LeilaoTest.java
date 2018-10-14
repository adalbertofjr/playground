package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import br.com.alura.leilao.builder.LeilaoBuilder;
import br.com.alura.leilao.exception.LanceMenorQueMaiorLanceException;
import br.com.alura.leilao.exception.LanceRealizadoIgualAoUltimoUsuarioException;
import br.com.alura.leilao.exception.UsuarioJaRealizouCincoLancesException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * LeilaoTest
 * Created by Dave Fernandes Júnior on 12/10/2018.
 * Copyright © 2018. All rights reserved.
 */
public class LeilaoTest {
    public static final double DELTA = 0.0001;
    private final Leilao LEILAO = new Leilao("Console");
    private final Usuario DAVE = new Usuario("Dave");

    //Para cada teste:
    // 1 - Criar o cenário
    // 2 - Executar ação esparada
    // 3 - Executar o teste para um resultado esperado.


    //Nomeclatura
    //[nome do metodo][estado do metodo][resultado esperado]
    //[deve][resultado esperado][estado do metodo]

    @Test
    public void deve_RetornarDescricao_QuandoReceberDescricao() {
        //Executar ação esperada
        String descricaoDevolvido = LEILAO.getDescricao();

        //Executar o teste para um descricaoDevolvido esperado.
        //assertEquals("Console", descricaoDevolvido);

        assertThat(descricaoDevolvido, is("Console"));
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeUmLance() {
        LEILAO.propoe(new Lance(DAVE, 200.0));

        double maiorLanceDevolvidoParaUmLance = LEILAO.getMaiorLance();

        assertThat(maiorLanceDevolvidoParaUmLance, closeTo(200.00, DELTA));
    }

    @Test
    public void deve_RetornarMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdenCrescente() {
        LEILAO.propoe(new Lance(new Usuario("Hal"), 100.0));
        LEILAO.propoe(new Lance(DAVE, 200.0));

        double maiorLanceDevolvidoParaMaisDeUmLanceEmOrdemCrescente = LEILAO.getMaiorLance();

        assertThat(maiorLanceDevolvidoParaMaisDeUmLanceEmOrdemCrescente, closeTo(200.0, DELTA));
    }

//    @Test
//    public void deve_RetornaMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
//        LEILAO.propoe(new Lance(new Usuario("Hal"), 100.0));
//        LEILAO.propoe(new Lance(DAVE, 200.0));
//
//        double maiorLanceDevolvidoParaMaisDeUmLanceEmOrdemDecrescente = LEILAO.getMaiorLance();
//
////        assertEquals(200.0, maiorLanceDevolvidoParaMaisDeUmLanceEmOrdemDecrescente, DELTA);
//        assertThat(maiorLanceDevolvidoParaMaisDeUmLanceEmOrdemDecrescente, closeTo(200.00, DELTA));
//    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeUmLance() {
        LEILAO.propoe(new Lance(DAVE, 200.0));

        double menorLanceDevolvidoParaUmLance = LEILAO.getMenorLance();

        assertThat(menorLanceDevolvidoParaUmLance, closeTo(200.0, DELTA));
    }

    @Test
    public void deve_RetornarMenorLance_QuandoRecebeMaisDeUmLanceEmOrdenCrescente() {
        LEILAO.propoe(new Lance(new Usuario("Hal"), 100.0));
        LEILAO.propoe(new Lance(DAVE, 200.0));

        double menorLanceDevolvidoParaMaisDeUmLanceEmOrdemCrescente = LEILAO.getMenorLance();

        assertThat(menorLanceDevolvidoParaMaisDeUmLanceEmOrdemCrescente, closeTo(100.0, DELTA));
    }

    // Leilão não aceita lance menor que o maior
//    @Test
//    public void deve_RetornaMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
//        LEILAO.propoe(new Lance(DAVE, 200.0));
//        LEILAO.propoe(new Lance(new Usuario("Hal"), 100.0));
//
//        double menorLanceDevolvidoParaUmLanceEmOrdemDecrescente = LEILAO.getMenorLance();
//
//        assertEquals(100.0, menorLanceDevolvidoParaUmLanceEmOrdemDecrescente, DELTA);
//    }

    @Test
    public void deve_RetornarOsTresMaioresLances_QuandoRecebeExatosTresLances() {
        LEILAO.propoe(new Lance(DAVE, 200.0));
        LEILAO.propoe(new Lance(new Usuario("Hal"), 300.0));
        LEILAO.propoe(new Lance(DAVE, 400.0));

        List<Lance> tresMaioresLancesDevolvidosParaTresLances = LEILAO.getTresMaioresLances();

//        assertEquals(3, tresMaioresLancesDevolvidosParaTresLances.size());
//        assertEquals(400.0, tresMaioresLancesDevolvidosParaTresLances.get(0).getValor(), DELTA);
//        assertEquals(300.0, tresMaioresLancesDevolvidosParaTresLances.get(1).getValor(), DELTA);
//        assertEquals(200.0, tresMaioresLancesDevolvidosParaTresLances.get(2).getValor(), DELTA);

        assertThat(tresMaioresLancesDevolvidosParaTresLances, hasSize(equalTo(3)));
        assertThat(tresMaioresLancesDevolvidosParaTresLances, hasItem(new Lance(DAVE, 200.0)));
        assertThat(tresMaioresLancesDevolvidosParaTresLances, hasItem(new Lance(new Usuario("Hal"), 300.0)));
        assertThat(tresMaioresLancesDevolvidosParaTresLances, hasItem(new Lance(DAVE, 400.0)));

    }

    @Test
    public void deve_RetornarOsTresMaioresLances_QuandoReceberNenhumLance() {
        List<Lance> tresMaioresLancesDevolvidosParaNenhumLance = LEILAO.getTresMaioresLances();

        assertThat(tresMaioresLancesDevolvidosParaNenhumLance, hasSize(equalTo(0)));
    }

    @Test
    public void deve_RetornarOsTresMaioresLances_QuandoReceberApenasUmLance() {
        LEILAO.propoe(new Lance(DAVE, 200.0));

        List<Lance> tresMaioresLancesDevolvidosParaUmLance = LEILAO.getTresMaioresLances();

        assertThat(tresMaioresLancesDevolvidosParaUmLance, hasSize(equalTo(1)));
        assertThat(tresMaioresLancesDevolvidosParaUmLance.get(0).getValor(), closeTo(200.0, DELTA));
    }

    @Test
    public void deve_RetornarOsTresMaioresLances_QuandoReceberDoisLances() {
        LEILAO.propoe(new Lance(DAVE, 200.0));
        LEILAO.propoe(new Lance(new Usuario("Hal"), 300.0));

        List<Lance> tresMaioresLancesDevolvidosParaDoisLances = LEILAO.getTresMaioresLances();

        assertThat(tresMaioresLancesDevolvidosParaDoisLances, hasSize(equalTo(2)));
        assertThat(tresMaioresLancesDevolvidosParaDoisLances, contains(
                new Lance(new Usuario("Hal"), 300.0),
                new Lance(DAVE, 200.0)
        ));

    }

    @Test
    public void deve_RetornarOsTresMaioresLances_QuandoRecebeMaisDeTresLances() {
        LEILAO.propoe(new Lance(new Usuario("Hal"), 400.0));
        LEILAO.propoe(new Lance(DAVE, 500.0));
        LEILAO.propoe(new Lance(new Usuario("Hal"), 600.0));
        LEILAO.propoe(new Lance(DAVE, 700.0));

        List<Lance> tresMaioresLancesDevolvidosParaQuatroLances = LEILAO.getTresMaioresLances();

        assertThat(tresMaioresLancesDevolvidosParaQuatroLances, hasSize(equalTo(3)));
        assertThat(tresMaioresLancesDevolvidosParaQuatroLances, contains(
                new Lance(DAVE, 700.0),
                new Lance(new Usuario("Hal"), 600.0),
                new Lance(DAVE, 500.0)
        ));


        LEILAO.propoe(new Lance(new Usuario("Hal"), 800.0));
        LEILAO.propoe(new Lance(DAVE, 900.0));

        List<Lance> tresMaioresLancesDevolvidosParaSeisLances = LEILAO.getTresMaioresLances();

        assertThat(tresMaioresLancesDevolvidosParaSeisLances, hasSize(equalTo(3)));
        assertThat(tresMaioresLancesDevolvidosParaSeisLances, contains(
                new Lance(DAVE, 900.0),
                new Lance(new Usuario("Hal"), 800.0),
                new Lance(DAVE, 700.0)
        ));
    }

    @Test
    public void deve_RetornarZeroParaMaiorLance_QuandoNaoTiverLance() {
        double maiorLanceDevolvido = LEILAO.getMaiorLance();

        assertThat(maiorLanceDevolvido, closeTo(0.0, DELTA));
    }

    @Test
    public void deve_RetornarZerpoParaMenorLance_QuandoNaoTiverLance() {
        double menorLanceDevolvido = LEILAO.getMenorLance();

        assertThat(menorLanceDevolvido, closeTo(0.0, DELTA));
    }

    @Test(expected = LanceMenorQueMaiorLanceException.class)
    public void deve_LancarException_QuandoLanceForMenorQueMaiorLance() {
        LEILAO.propoe(new Lance(DAVE, 700.0));
        LEILAO.propoe(new Lance(new Usuario("Hal"), 600.0));
    }

    @Test(expected = LanceRealizadoIgualAoUltimoUsuarioException.class)
    public void deve_LancarException_QuandoForMesmoUsuarioDoUltimoLance() {
        LEILAO.propoe(new Lance(DAVE, 700.0));
        LEILAO.propoe(new Lance(new Usuario("Dave"), 800.0));
    }

    @Test(expected = UsuarioJaRealizouCincoLancesException.class)
    public void deve_LancarException_QuandoForMaisQueCincoLancesDoMesmoUsuario() {
        Usuario hal = new Usuario("Hal");

        // Refatorando para utilizar o padrão builder para preparar o objeto LEILAO
       /* LEILAO.propoe(new Lance(DAVE, 100.0));
        LEILAO.propoe(new Lance(hal, 200.0));
        LEILAO.propoe(new Lance(DAVE, 300.0));
        LEILAO.propoe(new Lance(hal, 400.0));
        LEILAO.propoe(new Lance(DAVE, 500.0));
        LEILAO.propoe(new Lance(hal, 600.0));
        LEILAO.propoe(new Lance(DAVE, 700.0));
        LEILAO.propoe(new Lance(hal, 800.0));
        LEILAO.propoe(new Lance(DAVE, 900.0));
        LEILAO.propoe(new Lance(hal, 1000.0));
        LEILAO.propoe(new Lance(DAVE, 1100.0));
        LEILAO.propoe(new Lance(hal, 1200.0));*/

        Leilao leilao = new LeilaoBuilder("Console")
                .lance(DAVE, 100.0)
                .lance(hal, 200.0)
                .lance(DAVE, 300.0)
                .lance(hal, 400.0)
                .lance(DAVE, 500.0)
                .lance(hal, 600.0)
                .lance(DAVE, 700.0)
                .lance(hal, 800.0)
                .lance(DAVE, 900.0)
                .lance(hal, 1000.0)
                .lance(DAVE, 1000.0)
                .build();
    }
}