package br.com.amcosta.alura.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if (lances.isEmpty() || !this.lances.get(this.lances.size() - 1).getUsuario().equals(lance.getUsuario())) {
			int quantidade = this.quantificarLancesDoUsuario(lance.getUsuario());
			if (quantidade < 5) {
				lances.add(lance);
			}
		}
	}

	private int quantificarLancesDoUsuario(Usuario usuario) {
		int quantidade = 0;
		for (Lance lance : this.lances) {
			if (lance.getUsuario().equals(usuario)) {
				quantidade++;
			}
		}

		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobrarLance(Usuario usuario) {
	    if (this.lances.isEmpty()) {
	        return;
        }

		Lance ultimoLance = null;
		for (Lance lance : this.lances) {
			if (lance.getUsuario().equals(usuario)) {
				ultimoLance = lance;
			}
		}

		if (ultimoLance != null) {
			double valorDobrado = ultimoLance.getValor() * 2;
			this.propoe(new Lance(ultimoLance.getUsuario(), valorDobrado));
		}
    }
}
