package br.com.amcosta.alura.tdd;

public class Avaliador {

    private double menorLance = Double.POSITIVE_INFINITY;
    private double maiorLance = Double.NEGATIVE_INFINITY;

    public void avalia(Leilao leilao) {
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
}
