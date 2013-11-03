package edu.ibta.cg2.componente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu {
	
	private JMenuBar barraMenu;
	private JMenu menuArquivo;
	private JMenu menu2D;
	private JMenu menuAjuda;
	private List<JMenuItem> itensArquivo;
	private List<JMenuItem> itens2D;
	private List<JMenuItem> itensAjuda;
	
	public JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArquivo());
			barraMenu.add(getMenu2D());
			barraMenu.add(getMenuAjuda());
		}
		return barraMenu;
	}

	private JMenu getMenuArquivo() {
		List<JMenuItem> prov;
		if (menuArquivo == null) {
			menuArquivo = new JMenu();
			menuArquivo.setText("Arquivo");
			prov = getItensArquivo();
			for (int i = 0; i < prov.size(); i++)
				menuArquivo.add(prov.get(i));
			menuArquivo.setMnemonic(KeyEvent.VK_A);
		}
		return menuArquivo;
	}

	private List<JMenuItem> getItensArquivo() {
		int contador = 0;
		if (itensArquivo == null) {
			itensArquivo = new ArrayList<JMenuItem>();
			for (int i = 0; i < 3; i++)
				itensArquivo.add(new JMenuItem());
			itensArquivo.get(contador).setText("Abrir");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_S);
			itensArquivo.get(contador).setText("Salvar");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_L);
			itensArquivo.get(contador).setText("Sair");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_I);
			sair(itensArquivo.get(2));
		}
		return itensArquivo;
	}

	private JMenu getMenu2D() {
		List<JMenuItem> prov;
		if (menu2D == null) {
			menu2D = new JMenu();
			menu2D.setText("2D");
			prov = getItens2D();
			for (int i = 0; i < prov.size(); i++)
				menu2D.add(prov.get(i));
			menu2D.setMnemonic(KeyEvent.VK_2);
		}
		return menu2D;
	}

	private List<JMenuItem> getItens2D() {
		int contador = 0;
		if (itens2D == null) {
			itens2D = new ArrayList<JMenuItem>();
			for (int i = 0; i < 4; i++)
				itens2D.add(new JMenuItem());
			itens2D.get(contador).setText("Transladar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_T);
			itens2D.get(contador).setText("Escalonar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_E);
			itens2D.get(contador).setText("Rotacionar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_R);
			itens2D.get(contador).setText("Cisalhar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_C);
		}
		return itens2D;
	}

	private JMenu getMenuAjuda() {
		List<JMenuItem> prov;
		if (menuAjuda == null) {
			menuAjuda = new JMenu();
			menuAjuda.setText("Ajuda");
			prov = getItensAjuda();
			for (int i = 0; i < prov.size(); i++)
				menuAjuda.add(prov.get(i));
		}
		return menuAjuda;
	}

	private List<JMenuItem> getItensAjuda() {
		int contador = 0;
		if (itensAjuda == null) {
			itensAjuda = new ArrayList<JMenuItem>();
			for (int i = 0; i < 1; i++)
				itensAjuda.add(new JMenuItem());
			itensAjuda.get(contador).setText("Sobre");
			itensAjuda.get(contador++).setMnemonic(KeyEvent.VK_R);
		}
		sobre(itensAjuda.get(0));
		return itensAjuda;
	}

	private void sair(JMenuItem sair) {
		sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});
	}

	private void sobre(JMenuItem sobre) {
		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"<html><center><p>AUTOCADÊMICO</p></center><br /><br /><center><p>Projeto de Computação Gráfica</p></center></html>",
								"AUTOCADÊMICO", JOptionPane.PLAIN_MESSAGE, null);
			}
		});
		
		// Menu
		
	}

}
