package br.com.amcosta.alura.tdd;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valores igual ou menor que zero não são permitidos");
		}

		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
