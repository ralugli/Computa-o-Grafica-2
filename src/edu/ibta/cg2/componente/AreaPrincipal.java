package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import edu.ibta.cg2.model.Ponto;

public class AreaPrincipal extends JPanel implements MouseListener,
		MouseMotionListener {

	private static final long serialVersionUID = -6341888414590484470L;
	private int LARGURA = Janela.getLARGURA();
	private int ALTURA = Integer.parseInt(Math.round(Janela.getALTURA() * 0.88)
			+ "");

	private List<Ponto> poligono;
	private final int PONTOS_MAXIMOS = 3;

	public AreaPrincipal() {

		poligono = new ArrayList<Ponto>();
		addMouseListener(this);
		addMouseMotionListener(this);

		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setMaximumSize(new Dimension(LARGURA, ALTURA));
		setMinimumSize(new Dimension(LARGURA, ALTURA));
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Ponto ponto;
		int xPos = e.getX();
		int yPos = e.getY();
		if (poligono.size() < PONTOS_MAXIMOS) {
			ponto = new Ponto(xPos, yPos);
			poligono.add(ponto);
			repaint();
		}
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

		System.out.println("X: " + xPos + " Y: " + yPos);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void paintComponent(Graphics g) {
		int x[] = new int[poligono.size()];
		int y[] = new int[poligono.size()];

		super.paintComponent(g);

		for (int i = 0; i < poligono.size(); i++)
			g.fillOval((poligono.get(i).getX() - 5), (poligono.get(i).getY() - 5), 10, 10);

		for (int i = 0; i < poligono.size(); i++) {
			x[i] = poligono.get(i).getX();
			y[i] = poligono.get(i).getY();
		}

		if(poligono.size() == 3)
			g.drawPolygon(x, y, poligono.size());
	}

}
