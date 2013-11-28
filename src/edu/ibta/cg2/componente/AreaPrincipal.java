package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class AreaPrincipal extends JPanel implements MouseListener,
		MouseMotionListener {

	private Poligono poligono;
	private Ponto ponto;
	private static final long serialVersionUID = -6341888414590484470L;
	private int LARGURA = Janela.getLARGURA();
	private int ALTURA = Integer.parseInt(Math.round(Janela.getALTURA() * 0.88)
			+ "");

	public AreaPrincipal() {

		addMouseListener(this);
		addMouseMotionListener(this);

		setLayout(null);
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setMaximumSize(new Dimension(LARGURA, ALTURA));
		setMinimumSize(new Dimension(LARGURA, ALTURA));
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		poligono = new Poligono();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Ponto ponto;
		int xPos = e.getX() - 10;
		int yPos = e.getY() - 10;

		ponto = new Ponto(xPos, yPos);
		poligono.adicionaPonto(ponto);

		// Marcação
		Marcacao marcacao = new Marcacao(xPos, yPos);
		marcacao.setBounds(xPos, yPos, 20, 20);
		add(marcacao);
		validate();
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();

		BarraStatus.atualCoordenadas(xPos, yPos);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
