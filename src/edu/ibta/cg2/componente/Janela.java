package edu.ibta.cg2.componente;

import javax.swing.JFrame;

public class Janela extends JFrame {
	
	private final int LARGURA = 1000;
	private final int ALTURA = 800;
	
	public Janela(){
		interfaceUsuario();
	}
	
	private final void interfaceUsuario(){
		
		// Criação da janela
		setTitle("AUTOCADEMICO");
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}