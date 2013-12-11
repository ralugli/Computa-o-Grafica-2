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

import edu.ibta.cg2.arquivos.AbrirArquivo;
import edu.ibta.cg2.arquivos.SalvarArquivo;
import edu.ibta.cg2.model.Operacoes;
import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class Menu {

	private JMenuBar barraMenu;
	private JMenu menuArquivo;
	private JMenu menu2D;
	private JMenu menuAjuda;
	private List<JMenuItem> itensArquivo;
	private List<JMenuItem> itens2D;
	private List<JMenuItem> itensAjuda;

	private int transl[] = new int[2];
	private int espel;
	private int escal[] = new int[2];
	private int rotac;
	private int cisal[] = new int[2];

	private AreaPrincipal ap;

	public Menu(AreaPrincipal ap) {
		this.ap = ap;
	}

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

			for (int i = 0; i < 4; i++)
				itensArquivo.add(new JMenuItem());

			itensArquivo.get(contador).setText("Novo");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_N);
			itensArquivo.get(contador).setText("Abrir");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_S);
			itensArquivo.get(contador).setText("Salvar");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_L);
			itensArquivo.get(contador).setText("Sair");
			itensArquivo.get(contador++).setMnemonic(KeyEvent.VK_I);

			novo(itensArquivo.get(0));
			abrir(itensArquivo.get(1));
			salvar(itensArquivo.get(2));
			sair(itensArquivo.get(3));
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

			for (int i = 0; i < 5; i++)
				itens2D.add(new JMenuItem());

			itens2D.get(contador).setText("Transladar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_T);
			itens2D.get(contador).setText("Espelhar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_S);
			itens2D.get(contador).setText("Escalonar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_E);
			itens2D.get(contador).setText("Rotacionar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_R);
			itens2D.get(contador).setText("Cisalhar");
			itens2D.get(contador++).setMnemonic(KeyEvent.VK_C);

			transladar(itens2D.get(0));
			espelhar(itens2D.get(1));
			escalonar(itens2D.get(2));
			rotacionar(itens2D.get(3));
			cissalhar(itens2D.get(4));
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

	private void novo(JMenuItem novo) {

		novo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int escolha;

				if (ap != null) {

					escolha = JOptionPane.showConfirmDialog(null,
							"Você tem certeza disto?", "Confirmação",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (escolha == JOptionPane.OK_OPTION) {
						limparArea();
					}
				}

			}
		});
	}

	public void abrir(JMenuItem abrir) {

		abrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				limparArea();

				AbrirArquivo.escolhe();
				adicionarMarcacoes();

				ap.validate();
				ap.repaint();
			}

		});
	}

	public void salvar(JMenuItem salvar) {

		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				SalvarArquivo.salva();

			}

		});
	}

	private void sair(JMenuItem sair) {

		sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});
	}

	private void transladar(final JMenuItem transladar) {

		transladar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Translacao t = new Translacao(null);

				if (t.alterarDados()) {

					transl[0] = t.getOrientacao();
					transl[1] = t.getValor();

					if (AreaPrincipal.poligono != null
							&& AreaPrincipal.marcacoes != null) {

						switch (transl[0]) {

						case 1:
							AreaPrincipal.poligono = Operacoes.translacao(
									AreaPrincipal.poligono, transl[1], true);
							break;
						case 2:
							AreaPrincipal.poligono = Operacoes.translacao(
									AreaPrincipal.poligono, transl[1], false);
							break;
						case 3:
							AreaPrincipal.poligono = Operacoes.translacao(
									AreaPrincipal.poligono, transl[1]);
							break;
						}

						moverMarcacoes();

					}

				}

				t.dispose();

			}

		});
	}

	private void espelhar(final JMenuItem espelhar) {

		espelhar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Espelhamento esp = new Espelhamento(null);

				if (esp.alterarDados()) {

					espel = esp.getOrientacao();

					if (AreaPrincipal.poligono != null
							&& AreaPrincipal.marcacoes != null) {

						switch (espel) {

						case 1:
							AreaPrincipal.poligono = Operacoes.espelhamento(
									AreaPrincipal.poligono, true);
							break;
						case 2:
							AreaPrincipal.poligono = Operacoes.espelhamento(
									AreaPrincipal.poligono, false);
							break;
						case 3:
							AreaPrincipal.poligono = Operacoes
									.espelhamento(AreaPrincipal.poligono);
							break;
						}

						moverMarcacoes();

					}

				}

				esp.dispose();

			}

		});
	}

	private void escalonar(final JMenuItem espelhar) {

		espelhar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Escalonamento esc = new Escalonamento(null);

				if (esc.alterarDados()) {

					escal[0] = esc.getOrientacao();
					escal[1] = esc.getValor();

					if (AreaPrincipal.poligono != null
							&& AreaPrincipal.marcacoes != null) {

						switch (escal[0]) {

						case 1:
							AreaPrincipal.poligono = Operacoes.escalonamento(
									AreaPrincipal.poligono, escal[1], true);
							break;
						case 2:
							AreaPrincipal.poligono = Operacoes.escalonamento(
									AreaPrincipal.poligono, escal[1], false);
							break;
						case 3:
							AreaPrincipal.poligono = Operacoes.escalonamento(
									AreaPrincipal.poligono, escal[1]);
							break;
						}

						moverMarcacoes();

					}

				}

				esc.dispose();

			}

		});
	}

	private void rotacionar(final JMenuItem rotacionar) {

		rotacionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Rotacao rot = new Rotacao(null);

				if (rot.alterarDados()) {

					rotac = rot.getAngulo();

					if (AreaPrincipal.poligono != null
							&& AreaPrincipal.marcacoes != null) {

						AreaPrincipal.poligono = Operacoes.rotacao(
								AreaPrincipal.poligono, rotac);
						moverMarcacoes();

					}

				}

				rot.dispose();

			}

		});
	}

	private void cissalhar(final JMenuItem cissalhar) {

		cissalhar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cisalhamento ciss = new Cisalhamento(null);

				if (ciss.alterarDados()) {

					cisal[0] = ciss.getOrientacao();
					cisal[1] = ciss.getAngulo();

					if (AreaPrincipal.poligono != null
							&& AreaPrincipal.marcacoes != null) {

						switch (cisal[0]) {

						case 1:
							AreaPrincipal.poligono = Operacoes.cisalhamento(
									AreaPrincipal.poligono, cisal[1], true);
							break;
						case 2:
							AreaPrincipal.poligono = Operacoes.cisalhamento(
									AreaPrincipal.poligono, cisal[1], false);
							break;
						}

						moverMarcacoes();

					}

				}

				ciss.dispose();

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

	}

	private void limparArea() {

		AreaPrincipal.poligono.destruir();
		AreaPrincipal.marcacoes.clear();

		ap.removeAll();
		ap.validate();
		ap.repaint();

	}

	private void adicionarMarcacoes() {

		Ponto auxPto;
		Poligono aux = AreaPrincipal.poligono;
		Marcacao marcAux;

		for (int i = 0; i < aux.numeroPontos(); i++) {

			auxPto = aux.retornaPonto(i);
			marcAux = new Marcacao(auxPto);
			marcAux.setBounds(auxPto.getX() - 10, auxPto.getY() - 10, 20, 20);

			AreaPrincipal.marcacoes.add(marcAux);

			ap.add(marcAux);
			
		}

		ap.validate();
		ap.repaint();
		
	}

	private void moverMarcacoes() {

		Poligono aux = AreaPrincipal.poligono;

		for (int i = 0; i < AreaPrincipal.marcacoes.size(); i++) {

			AreaPrincipal.marcacoes.get(i).setBounds(
					aux.retornaPonto(i).getX() - 10,
					aux.retornaPonto(i).getY() - 10, 20, 20);

		}
		
		ap.validate();
		ap.repaint();

	}

}
