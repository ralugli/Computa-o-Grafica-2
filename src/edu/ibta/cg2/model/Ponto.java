package edu.ibta.cg2.model;

public class Ponto {

	private int x;
	private int y;
	private int orientacao;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
		this.orientacao = 3;
	}
	
	public Ponto(int x, int y, int orientacao){
		this.x = x;
		this.y = y;
		this.orientacao = orientacao;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "X: " + this.x + " - Y: " + this.y + " - Orientação: "+ this.orientacao;
	}

}