package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import edu.ibta.cg2.model.Ponto;

public class AreaPrincipal extends JPanel implements MouseListener,
		MouseMotionListener {

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

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Ponto ponto;
		int xPos = e.getX();
		int yPos = e.getY();

		// Marcação
		Marcacao marcacao = new Marcacao(xPos, yPos, 0);
		marcacao.setBounds(xPos-10, yPos-10, 20, 20);
		add(marcacao);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseMoved(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();

		BarraStatus.atualCoordenadas(xPos, yPos);

		// System.out.println("X: " + xPos + " Y: " + yPos);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
