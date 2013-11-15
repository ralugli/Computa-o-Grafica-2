package edu.ibta.cg2.componente;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Janela extends JFrame {

	private static final long serialVersionUID = -4658786359260670722L;
	private static int LARGURA = 1200;
	private static int ALTURA = 700;

	// Componentes
	private Menu menu = new Menu();
	private AreaPrincipal areaPrincipal = new AreaPrincipal();
	private BarraStatus barraStatus = new BarraStatus();

	public Janela() {
		interfaceUsuario();
	}

	private final void interfaceUsuario() {

		/**
		 * Criação de Janela principal.
		 */

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					
					getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
					
					// Propriedades da Janela
					setTitle("AUTOCADEMICO");
					setSize(LARGURA, ALTURA);
					setResizable(false);
					setLocationRelativeTo(null);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					setVisible(true);
					
					// Componentes
					setJMenuBar(menu.getBarraMenu());
					getContentPane().add(areaPrincipal);
					getContentPane().add(barraStatus);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
		}
	}

	public static int getLARGURA() {
		return LARGURA;
	}

	public static int getALTURA() {
		return ALTURA;
	}
	
}