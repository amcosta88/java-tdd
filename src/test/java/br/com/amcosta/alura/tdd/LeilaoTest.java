package br.com.amcosta.alura.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;

    @Before
    public void setUp() {
        this.usuario1 = new Usuario(1, "usuario 1");
        this.usuario2 = new Usuario(2, "usuario 2");
        this.usuario3 = new Usuario(3, "usuario 3");
    }

    @Test
    public void testMaiorMenorPreco() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1200)
                .proporLance(this.usuario3, 1800)
                .proporLance(this.usuario1, 120)
                .proporLance(this.usuario2, 5869)
                .proporLance(this.usuario3, 630)
                .construir();

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(120, avaliador.getMenorLance(), 0.0001);
        Assert.assertEquals(5869, avaliador.getMaiorLance(), 0.0001);
    }

    @Test
    public void testMedia() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1000)
                .proporLance(this.usuario2, 1000)
                .proporLance(this.usuario1, 1000)
                .construir();

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1000, avaliador.mediaDosLances(), 0.0001);
    }

    @Test
    public void testLeilaoComUmLance() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1500)
                .construir();

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1500, avaliador.getMenorLance(), 0.0001);
        Assert.assertEquals(1500, avaliador.getMaiorLance(), 0.0001);
    }

    @Test
    public void testLancesEmOrdemDecrescente() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1000)
                .proporLance(this.usuario2, 750)
                .proporLance(this.usuario1, 500)
                .proporLance(this.usuario2, 150)
                .construir();

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1500, avaliador.getMaiorLance(), 0.0001);
        Assert.assertEquals(150, avaliador.getMenorLance(), 0.0001);
    }

    @Test
    public void testPegaOsTresMaioresLances() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1000)
                .proporLance(this.usuario2, 750)
                .proporLance(this.usuario1, 500)
                .proporLance(this.usuario2, 150)
                .construir();

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(3, avaliador.getTresMaiores().size());
        Assert.assertEquals(1500, avaliador.getTresMaiores().get(0).getValor(), 0.0001);
        Assert.assertEquals(1300, avaliador.getTresMaiores().get(1).getValor(), 0.0001);
        Assert.assertEquals(1000, avaliador.getTresMaiores().get(2).getValor(), 0.0001);
    }

    @Test
    public void testNaoDeveAceitar2LancesDoMesmoUsuario() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario1, 1300)
                .construir();

        Assert.assertEquals(1, leilao.getLances().size());
    }

    @Test
    public void testNaoDeveAceitarMaisQue5LancesDoMesmoUsuario() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .proporLance(this.usuario1, 1500)
                .proporLance(this.usuario2, 1300)
                .construir();

        Assert.assertEquals(10, leilao.getLances().size());
    }

    @Test
    public void testNaoDeveDobrarLanceDeUmLanceQueNaoExiste() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1")).construir();
        leilao.dobrarLance(this.usuario1);
        Assert.assertEquals(0, leilao.getLances().size());
    }

    @Test
    public void testDeveDobrarOLanceDoUltimoUsuario() {
        Leilao leilao = (new ConstrutorDeLeilao("Leilão de teste 1"))
                .proporLance(this.usuario1, 100)
                .proporLance(this.usuario2, 150)
                .proporLance(this.usuario1, 170)
                .proporLance(this.usuario2, 200)
                .construir();

        leilao.dobrarLance(usuario1);

        Assert.assertEquals(5, leilao.getLances().size());
        Assert.assertEquals(340, leilao.getLances().get(4).getValor(), 0.0001);
    }
}
