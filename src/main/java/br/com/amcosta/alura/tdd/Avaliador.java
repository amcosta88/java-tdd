package br.com.amcosta.alura.tdd;

import java.util.List;

public class Avaliador {

    private Leilao leilao;
    private double menorLance = Double.POSITIVE_INFINITY;
    private double maiorLance = Double.NEGATIVE_INFINITY;

    public Avaliador(Leilao leilao) {
        this.leilao = leilao;
    }

    public void avalia() {
        for (Lance lance : leilao.getLances()) {
            double valor = lance.getValor();

            System.out.println(valor);
            if (valor > maiorLance) {
                this.maiorLance = valor;
            }

            if (valor < menorLance) {
                this.menorLance = valor;
            }
        }
    }

    public double getMenorLance() {
        return this.menorLance;
    }

    public double getMaiorLance() {
        return this.maiorLance;
    }

    public double mediaDosLances() {
        double total = 0;
        List<Lance> lances = leilao.getLances();

        for (Lance lance : lances) {
            total += lance.getValor();
        }

        return total / lances.size();
    }
}
