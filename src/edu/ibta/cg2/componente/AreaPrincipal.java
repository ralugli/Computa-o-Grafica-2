package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import edu.ibta.cg2.model.Operacoes;
import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class AreaPrincipal extends JPanel implements MouseListener,
		MouseMotionListener {

	@SuppressWarnings("unused")
	private Menu menu;

	public static Poligono poligono;
	public static List<Marcacao> marcacoes;
	private Ponto ponto;
	private static final long serialVersionUID = -6341888414590484470L;
	private int LARGURA = Janela.getLARGURA();
	private int ALTURA = Integer.parseInt(Math.round(Janela.getALTURA() * 0.88)
			+ "");

	public AreaPrincipal() {

		menu = new Menu(this);

		addMouseListener(this);
		addMouseMotionListener(this);

		setLayout(null);
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setMaximumSize(new Dimension(LARGURA, ALTURA));
		setMinimumSize(new Dimension(LARGURA, ALTURA));
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		poligono = new Poligono();
		marcacoes = new ArrayList<Marcacao>();

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Marcacao marcacao;

		// Ponto ponto;
		int xPos = e.getX();
		int yPos = e.getY();

		ponto = new Ponto(xPos, yPos);
		poligono.adicionaPonto(ponto);

		// Marcação
		marcacao = new Marcacao(ponto);
		marcacao.setBounds(xPos - 10, yPos - 10, 20, 20);
		marcacoes.add(marcacao);
		add(marcacoes.get(marcacoes.size() - 1));

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

		Graphics2D g2 = (Graphics2D) g;
		poligono = Operacoes.isConvexo(poligono);

		if (poligono.numeroPontos() > 2) {

			GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
					poligono.numeroPontos());
			polygon.moveTo(poligono.retornaPonto(0).getX(), poligono
					.retornaPonto(0).getY());

			for (int indice = 1; indice < poligono.numeroPontos(); indice++) {
				polygon.lineTo(poligono.retornaPonto(indice).getX(), poligono
						.retornaPonto(indice).getY());
			}
			
			removeAll();

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				Marcacao marcAux = new Marcacao(poligono.retornaPonto(i),
						poligono.retornaPonto(i).getOrientacao());

				marcAux.setBounds(poligono.retornaPonto(i).getX() - 10,
						poligono.retornaPonto(i).getY() - 10, 20, 20);
				add(marcAux);

				validate();
				repaint();

			}

			polygon.closePath();
			g2.draw(polygon);

		}

	}

}
