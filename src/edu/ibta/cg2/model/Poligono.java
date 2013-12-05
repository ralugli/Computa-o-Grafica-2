package edu.ibta.cg2.model;

import java.util.ArrayList;
import java.util.List;

public class Poligono {

	private List<Ponto> pontos;

	public Poligono() {
		this.pontos = new ArrayList<Ponto>();
	}

	public Poligono(Ponto ponto) {
		this.pontos = new ArrayList<Ponto>();
		this.pontos.add(ponto);
	}

	public int numeroPontos() {
		return this.pontos.size();
	}

	public Ponto retornaPonto(int indice) {
		return this.pontos.get(indice);
	}

	public void adicionaPonto(Ponto ponto) {
		this.pontos.add(ponto);
	}

	public List<Ponto> getPontos() {
		return this.pontos;
	}

	public void destruir() {
		this.pontos.clear();
	}

	@Override
	public String toString() {

		String mensagem = "";

		if (this.pontos.isEmpty())
			return "Sem pontos";
		else {

			for (int i = 0; i < this.pontos.size(); i++)
				mensagem += this.pontos.get(i).toString() + "\n";

			return mensagem;
		}

	}

}