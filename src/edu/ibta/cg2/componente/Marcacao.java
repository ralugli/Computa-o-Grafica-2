package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class Marcacao extends JButton {

	private static final long serialVersionUID = -5754569411789624121L;
	private final int DIAMETRO = 20;
	private Color bgcor;
	private int posicaoX;
	private int posicaoY;

	/**
	 * @param tipoPonto
	 *            - 0 - Côncavo 1 - Convexo
	 */
	public Marcacao(int posicaoX, int posicaoY, int tipoPonto) {
		super("");

		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;

		switch (tipoPonto) {
		case 0:
			this.bgcor = Color.GREEN;
			break;
		case 1:
			this.bgcor = Color.RED;
			break;
		}
		
		formaBotao();

	}

	public Marcacao(int posicaoX, int posicaoY) {
		super("");

		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.bgcor = Color.DARK_GRAY;
		
		formaBotao();
	}
	
	private void formaBotao() {
		Dimension size = getPreferredSize();
		size.width = DIAMETRO;
		size.height = DIAMETRO;
		setPreferredSize(size);

		setContentAreaFilled(false);

		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				// int xPos = e.getX();
				// int yPos = e.getY();

				System.out.println("X: " + getPosicaoX() + " Y: "
						+ getPosicaoY());
			}

		});
	}

	protected void paintComponent(Graphics g) {
		
		g.setColor(bgcor);
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}
	
	protected void paintLines(Poligono poligono, Graphics g){
		
		int max = poligono.numeroPontos();
		
		if(poligono.numeroPontos() > 1){
	
			Ponto ultimo_ponto = poligono.retornaPonto(max);
			Ponto penultimo = poligono.retornaPonto(max-1);
				
			g.drawLine(penultimo.getX(), penultimo.getY(), ultimo_ponto.getX(), ultimo_ponto.getY());	     
		}
		
	}
	
	protected void paintLineAll(Poligono poligono){
		List<Ponto> pontos = poligono.getPontos();
		for(Ponto p : pontos){}
	}

	/* GET e SET
	 * */
	
	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

}
