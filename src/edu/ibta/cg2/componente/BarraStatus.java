package edu.ibta.cg2.componente;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BarraStatus extends JPanel {

	private static final long serialVersionUID = 7989841119819804937L;
	static JLabel areaTotal;
	static JLabel coordenadas;

	public BarraStatus() {
		super();
		areaTotal = new JLabel("Área Total: ");
		areaTotal.setHorizontalTextPosition(SwingConstants.LEFT);
		coordenadas = new JLabel("X:  Y: ");
		coordenadas.setHorizontalTextPosition(SwingConstants.RIGHT);
		add(areaTotal);
		add(coordenadas);
	}

	public static void atualCoordenadas(int x, int y) {
		coordenadas.setText("X: " + x + " Y: " + y);
	}

	public static void atualArea(int area) {
		areaTotal.setText("Area total: " + area);
	}
}
