package edu.ibta.cg2.componente;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BarraStatus extends JPanel {

	private static final long serialVersionUID = 7989841119819804937L;
	static JLabel areaTotal;
	static JLabel coordenadas;

	public BarraStatus() {
		super();
		
		setLayout(null);
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

	public static void atualArea(double area) {
		areaTotal.setText("Área total: " + area);
	}
	
	public void paintComponent(Graphics g) {
		
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = getBackground();
        Color color2 = color1.darker();
        
        int w = getWidth();
        int h = getHeight(); 
        
        GradientPaint gp = new GradientPaint(
                0, 0, color1,
                0, h, color2);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
