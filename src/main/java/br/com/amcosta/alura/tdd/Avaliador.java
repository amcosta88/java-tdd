package br.com.amcosta.alura.tdd;

import java.util.List;

public class Avaliador {

    private Leilao leilao;
    private double menorLance = Double.POSITIVE_INFINITY;
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private List<Lance> maiores;

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

            pegaOsMaiores(leilao);
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

    private void pegaOsMaiores(Leilao leilao) {
        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            public int compare(Lance o1, Lance o2) {
                if (o1.getValor() < o2.getValor()) return 1;
                if (o1.getValor() > o2.getValor()) return -1;
                return 0;
            }
        });

        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
    }

    public List<Lance> getTresMaiores() {
        return this.maiores;
    }
}
