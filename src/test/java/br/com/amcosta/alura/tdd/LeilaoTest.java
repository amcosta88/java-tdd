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
        Lance lance2 = new Lance(usuario1, 1200);
        Lance lance3 = new Lance(usuario1, 1800);

        Leilao leilao = new Leilao("Leilão de teste 1");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1200, avaliador.getMenorLance(), 0.0001);
        Assert.assertEquals(1800, avaliador.getMaiorLance(), 0.0001);
    }

    @Test
    public void testMedia() {
        Usuario usuario = new Usuario(1, "Usuário 1");
        Lance lance1 = new Lance(usuario, 1000);
        Lance lance2 = new Lance(usuario, 1000);
        Lance lance3 = new Lance(usuario, 1000);

        Leilao leilao = new Leilao("Leilão de teste 1");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        Avaliador avaliador = new Avaliador(leilao);
        avaliador.avalia();

        Assert.assertEquals(1000, avaliador.mediaDosLances(), 0.0001);
    }
}
