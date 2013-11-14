package edu.ibta.cg2.model;

public class Ponto {
	
	private int x;
	private int y;
	
	public Ponto(int x, int y){
		setX(x);
		setY(y);
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
	
}