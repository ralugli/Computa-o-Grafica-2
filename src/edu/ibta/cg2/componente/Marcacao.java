package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;

import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class Marcacao extends JButton {

	private static final long serialVersionUID = -5754569411789624121L;
	private final int DIAMETRO = 20;
	private Color bgcor;
	private Ponto posicao;

	/**
	 * @param tipoPonto
	 *            0 para Côncavo; 1 para Convexo
	 */
	public Marcacao(Ponto posicao, int tipoPonto) {
		super("");

		this.posicao = posicao;

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

	public Marcacao(Ponto posicao) {
		super("");

		this.posicao = posicao;
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

				System.out.println(posicao.toString());
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

	static void paintLines(Poligono poligono, Graphics g) {

		int max = poligono.numeroPontos();

		if (max > 1) {

			Ponto ultimo_ponto = poligono.retornaPonto(max - 1);
			Ponto penultimo = poligono.retornaPonto(max - 2);

			System.out.println(ultimo_ponto.toString());
			System.out.println(penultimo.toString());

			g.drawLine(penultimo.getX(), penultimo.getY(), ultimo_ponto.getX(),
					ultimo_ponto.getY());
		}

	}

	protected void paintLineAll(Poligono poligono, Graphics g) {

		List<Ponto> pontos = poligono.getPontos();
		int max = poligono.numeroPontos();

		if (max > 2) {
			for (Ponto p : pontos) {

				if (pontos.size() >= 2) {
					g.drawLine(p.getX(), p.getY(), p.getX() + 1, p.getY());
					pontos.remove(0);
				} else if (pontos.size() == 1) {

				}
			}
		}
	}

}
