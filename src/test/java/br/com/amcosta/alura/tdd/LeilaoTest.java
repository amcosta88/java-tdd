package br.com.amcosta.alura.tdd;

import org.junit.Assert;
import org.junit.Test;

public class LeilaoTest {

    @Test
    public void testMaiorMenorPreco() {

        Usuario usuario1 = new Usuario(1, "usuario 1");
        Usuario usuario2 = new Usuario(2, "usuario 2");
        Usuario usuario3 = new Usuario(3, "usuario 3");

        Lance lance1 = new Lance(usuario1, 1500);
        Lance lance2 = new Lance(usuario2, 1200);
        Lance lance3 = new Lance(usuario3, 1800);
        Lance lance4 = new Lance(usuario1, 120);
        Lance lance5 = new Lance(usuario2, 5869);
        Lance lance6 = new Lance(usuario3, 630);

        Leilao leilao = new Leilao("Leilão de teste 1");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);
        leilao.propoe(lance6);

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(120, avaliador.getMenorLance(), 0.0001);
        Assert.assertEquals(5869, avaliador.getMaiorLance(), 0.0001);
    }

    @Test
    public void testMedia() {
        Usuario usuario1 = new Usuario(1, "Usuário 1");
        Usuario usuario2 = new Usuario(1, "Usuário 1");
        Lance lance1 = new Lance(usuario1, 1000);
        Lance lance2 = new Lance(usuario2, 1000);
        Lance lance3 = new Lance(usuario1, 1000);

        Leilao leilao = new Leilao("Leilão de teste 1");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1000, avaliador.mediaDosLances(), 0.0001);
    }

    @Test
    public void testLeilaoComUmLance() {
        Usuario usuario1 = new Usuario(1, "usuario 1");
        Lance lance1 = new Lance(usuario1, 1500);

        Leilao leilao = new Leilao("Leilão de teste 1");
        leilao.propoe(lance1);

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1500, avaliador.getMenorLance(), 0.0001);
        Assert.assertEquals(1500, avaliador.getMaiorLance(), 0.0001);
    }

    @Test
    public void testLancesEmOrdemDecrescente() {
        Usuario usuario1 = new Usuario(1, "Maria");
        Usuario usuario2 = new Usuario(1, "Maria");
        Leilao leilao = new Leilao("Leilão de ordem descrescente");

        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1000));
        leilao.propoe(new Lance(usuario2, 750));
        leilao.propoe(new Lance(usuario1, 500));
        leilao.propoe(new Lance(usuario2, 150));

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1500, avaliador.getMaiorLance(), 0.0001);
        Assert.assertEquals(150, avaliador.getMenorLance(), 0.0001);
    }

    @Test
    public void testPegaOsTresMaioresLances() {
        Usuario usuario1 = new Usuario(1, "Maria");
        Usuario usuario2 = new Usuario(1, "Maria");
        Leilao leilao = new Leilao("Leilão de ordem descrescente");

        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1000));
        leilao.propoe(new Lance(usuario2, 750));
        leilao.propoe(new Lance(usuario1, 500));
        leilao.propoe(new Lance(usuario2, 150));

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(3, avaliador.getTresMaiores().size());
        Assert.assertEquals(1500, avaliador.getTresMaiores().get(0).getValor(), 0.0001);
        Assert.assertEquals(1300, avaliador.getTresMaiores().get(1).getValor(), 0.0001);
        Assert.assertEquals(1000, avaliador.getTresMaiores().get(2).getValor(), 0.0001);
    }

    @Test
    public void testNaoDeveAceitar2LancesDoMesmoUsuario() {
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 1");
        Leilao leilao = new Leilao("Produto 1");

        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario1, 1300));

        Assert.assertEquals(1, leilao.getLances().size());
    }

    @Test
    public void testNaoDeveAceitarMaisQue5LancesDoMesmoUsuario() {
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        Leilao leilao = new Leilao("Produto 1");

        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));
        leilao.propoe(new Lance(usuario1, 1500));
        leilao.propoe(new Lance(usuario2, 1300));

        Assert.assertEquals(10, leilao.getLances().size());
    }
}
