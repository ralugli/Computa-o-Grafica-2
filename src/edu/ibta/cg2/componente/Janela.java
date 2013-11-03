package edu.ibta.cg2.componente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Janela extends JFrame {

	private static final long serialVersionUID = -4658786359260670722L;
	private final int LARGURA = 1200;
	private final int ALTURA = 700;
	private Menu menu = new Menu();
	
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
					setTitle("AUTOCADEMICO");
					setSize(LARGURA, ALTURA);
					setLocationRelativeTo(null);
					setJMenuBar(menu.getBarraMenu());
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					setVisible(true);
					break;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: "+ e.getMessage());
		}
	}
}