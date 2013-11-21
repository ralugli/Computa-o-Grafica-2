package edu.ibta.cg2.componente;

import java.awt.BorderLayout;

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
	private Menu menu;
	private AreaPrincipal areaPrincipal;
	private BarraStatus barraStatus;

	public Janela() {
		super("AUTOCADEMICO");
		interfaceUsuario();
	}

	/**
	 * Criação de Janela principal.
	 */

	private final void interfaceUsuario() {

		menu = new Menu();
		areaPrincipal = new AreaPrincipal();
		barraStatus = new BarraStatus();

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());

					// Propriedades da Janela
					setSize(LARGURA, ALTURA);
					setResizable(false);
					setLocationRelativeTo(null);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					setVisible(true);

					// Componentes
					barraStatus.setLayout(new BoxLayout(barraStatus,
							BoxLayout.PAGE_AXIS));
					setJMenuBar(menu.getBarraMenu());
					getContentPane().add(areaPrincipal, BorderLayout.NORTH);
					getContentPane().add(barraStatus, BorderLayout.SOUTH);
					
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