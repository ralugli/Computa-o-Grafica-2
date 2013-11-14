package edu.ibta.cg2.componente;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class AreaPrincipal extends JPanel implements MouseListener, MouseMotionListener {
	
	private int LARGURA = Janela.getLARGURA();
	private int ALTURA =  Integer.parseInt(Math.round(Janela.getALTURA() * 0.8) + "");
	
	public AreaPrincipal(){
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setBackground(getBackground().GRAY);
		setPreferredSize(new Dimension(LARGURA,ALTURA));
		setMaximumSize(new Dimension(LARGURA,ALTURA));
		setMinimumSize(new Dimension(LARGURA,ALTURA));
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		setLayout(new FlowLayout());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
		int x = e.getX();
		int y = e.getY();
		
		BarraStatus.atualCoordenadas(x, y);
		
		System.out.println("X: "+ x + " Y: "+ y);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
