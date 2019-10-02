package br.com.amcosta.alura.tdd;

import org.junit.Assert;
import org.junit.Test;

public class VerificarAnoBissextoTest {
    private boolean verificarAno(int ano) {
        VerificarAnoBissexto teste = new VerificarAnoBissexto();
        return teste.ehBissexto(ano);
    }

    @Test
    public void testVerificarAnos() {
        VerificarAnoBissexto teste = new VerificarAnoBissexto();

        Assert.assertTrue(teste.ehBissexto(4));
        Assert.assertFalse(teste.ehBissexto(100));
        Assert.assertTrue(teste.ehBissexto(400));
        Assert.assertFalse(teste.ehBissexto(2019));
        Assert.assertTrue(teste.ehBissexto(2016));
    }
}
