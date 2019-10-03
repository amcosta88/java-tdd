package br.com.amcosta.alura.tdd;

public class ConstrutorDeLeilao {
    private Leilao leilao;

    public ConstrutorDeLeilao(String produto) {
        this.leilao = new Leilao(produto);
    }

    public ConstrutorDeLeilao proporLance(Usuario usuario, double valor) {
        this.leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao construir() {
        return this.leilao;
    }
}
