package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Marcacao extends JButton {

	private Color bgcor = Color.lightGray;
	private int circuferencia = 20;
	protected int posicaoX;
	protected int posicaoY;

	/*
	 * Tipo de Ponto 0 - Côncavo 1 - Convexo
	 */
	public Marcacao(int posicaoX, int posicaoY, int tipoPonto) {
		super("");
		
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;

		switch (tipoPonto) {
		case 0:
			this.bgcor = Color.green;
			break;
		case 1:
			this.bgcor = Color.red;
			break;
		}

		Dimension size = getPreferredSize();
		size.width = circuferencia;
		size.height = circuferencia;
		setPreferredSize(size);

		setContentAreaFilled(false);
		
		addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e)
            {
				int xPos = e.getX();
				int yPos = e.getY();

				System.out.println("X: " + getPosicaoX() + " Y: " + getPosicaoY());
            }
			
		});
		
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(bgcor);
		}
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}

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
