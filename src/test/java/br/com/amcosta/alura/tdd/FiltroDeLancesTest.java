package br.com.amcosta.alura.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiltroDeLancesTest {

    private Usuario usuarioTest;

    public void FiltroDeLancesTest() {
        this.usuarioTest = new Usuario("João");
    }

    private List<Lance> filtrarValores(List<Integer> valores) {
        ArrayList<Lance> lances = new ArrayList<Lance>();
        for (int valor : valores) {
            lances.add(new Lance(this.usuarioTest, valor));
        }

        return (new FiltroDeLances()).filtra(lances);
    }

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        List<Lance> resultado = this.filtrarValores(Arrays.asList(2000, 1000, 3000, 800));
        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        List<Lance> resultado = this.filtrarValores(Arrays.asList(600, 500, 700, 800));
        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesAcimaDe5000() {
        List<Lance> resultado = this.filtrarValores(Arrays.asList(6000, 5000, 7000, 8000));
        Assert.assertEquals(3, resultado.size());
        Assert.assertEquals(6000, resultado.get(0).getValor(), 0.00001);
        Assert.assertEquals(7000, resultado.get(1).getValor(), 0.00001);
        Assert.assertEquals(8000, resultado.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveEliminarLancesMenoresQue500() {
        List<Lance> resultado = this.filtrarValores(Arrays.asList(0, 50, 300, 500));
        Assert.assertEquals(0, resultado.size());
    }

    @Test
    public void deveEliminarLancesEntre700E1000() {
        List<Lance> resultado = this.filtrarValores(Arrays.asList(700, 1000, 800));
        Assert.assertEquals(0, resultado.size());
    }

    @Test
    public void deveEliminarLancesEntre3000E5000() {
        List<Lance> resultado = this.filtrarValores(Arrays.asList(3000, 5000, 4000));
        Assert.assertEquals(0, resultado.size());
    }
}
