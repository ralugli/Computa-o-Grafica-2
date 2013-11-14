package edu.ibta.cg2.componente;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BarraStatus extends JPanel {

	static JLabel areaTotal = new JLabel();
	static JLabel coordenadas = new JLabel();

	public BarraStatus() {
		add(areaTotal);
		add(coordenadas);
	}

	public static void atualCoordenadas(int x, int y) {
		coordenadas.setText(" / X: " + x + "  Y: " + y);
	}
	
	public static void atualArea(int area){
		areaTotal.setText("Area total: "+ area);
	}
}
