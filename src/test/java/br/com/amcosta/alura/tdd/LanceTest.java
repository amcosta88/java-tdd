package br.com.amcosta.alura.tdd;

import org.junit.Test;

public class LanceTest {

    private Usuario usuario;

    public void setUp() {
        this.usuario = new Usuario("Usuario 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaoDeveAceitarValoresIgualAZero() {
        Lance lance = new Lance(this.usuario, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaoDeveAceitarValoresNegativos() {
        Lance lance = new Lance(this.usuario, -100);
    }
}
