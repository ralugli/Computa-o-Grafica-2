package edu.ibta.cg2.model;

import java.util.ArrayList;

public class Poligono {

	ArrayList<Ponto> lista = new ArrayList<Ponto>();

	public Poligono(Ponto ponto) {

		lista.add(ponto);
	}

	public void espelhamento_horizontal(ArrayList lista) {

		int tamanho = lista.size(); // pega o numero de pontos no poligono
		int i;
		Ponto atual; // ponto em que as modificações serão feitas
		//Poligono novo = new Poligono(null); // este poligono será o resultado
											// das operações
		ArrayList<Ponto> nova_lista = new ArrayList<Ponto>();

		for (i = 0; i <= tamanho; i++) {  //este for torna os valores
			atual = (Ponto) lista.get(i); //originais do poligono negativos
			atual.x = (atual.x - (atual.x * 2)); //e armazena-os em uma nova array
			nova_lista.add(atual);

		}

		
	}

	public void espelhamento_vertical(ArrayList lista) {
		
		int tamanho = lista.size(); 
		int i;
		Ponto atual;
		ArrayList<Ponto> nova_lista = new ArrayList<Ponto>();

		for (i = 0; i <= tamanho; i++) {  
			atual = (Ponto) lista.get(i); 
			atual.y = (atual.y - (atual.y * 2)); 
			nova_lista.add(atual);

		}

	}

}
