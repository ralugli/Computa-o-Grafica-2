package edu.ibta.cg2.componente;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Escalonamento extends JDialog {

	private static final long serialVersionUID = 8674176711982556932L;

	private JPanel jContentPane = null;
	private JLabel lblOrientacao = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbOrientacao = null;
	private JLabel lblValor = null;
	private JTextField txtValor = null;
	private JPanel pnlButtons = null;
	private JButton btnOk = null;
	private JButton btnCancelar = null;
	protected boolean okSelecionado;

	public Escalonamento(Frame owner) {

		super(owner);
		initialize();

	}

	private void initialize() {

		this.setSize(411, 151);
		this.setTitle("Aumento/Diminuição");
		this.setContentPane(getJContentPane());

	}

	private JPanel getJContentPane() {

		if (jContentPane == null) {

			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.gridy = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints7.gridy = 1;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.ipadx = 30;
			gridBagConstraints7.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints5.gridy = 1;
			lblValor = new JLabel();
			lblValor.setText("Valor:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints.gridy = 0;
			lblOrientacao = new JLabel();
			lblOrientacao.setText("Orientação:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lblOrientacao, gridBagConstraints);
			jContentPane.add(getCmbOrientacao(), gridBagConstraints1);
			jContentPane.add(lblValor, gridBagConstraints5);
			jContentPane.add(getTxtValor(), gridBagConstraints7);
			jContentPane.add(getPnlButtons(), gridBagConstraints9);
		}

		return jContentPane;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getCmbOrientacao() {

		if (cmbOrientacao == null)
			cmbOrientacao = new JComboBox(new String[] { "Horizontal",
					"Vertical", "Ambos" });

		return cmbOrientacao;
	}

	private JTextField getTxtValor() {

		if (txtValor == null)
			txtValor = new JTextField();

		return txtValor;

	}

	private JPanel getPnlButtons() {

		if (pnlButtons == null) {

			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(0);
			flowLayout.setHgap(3);
			pnlButtons = new JPanel();
			pnlButtons.setLayout(flowLayout);
			pnlButtons.add(getBtnOk(), null);
			pnlButtons.add(getBtnCancelar(), null);

		}

		return pnlButtons;

	}

	private JButton getBtnOk() {

		if (btnOk == null) {

			btnOk = new JButton();
			btnOk.setText("OK");

			btnOk.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {

					try {

						Integer.parseInt(txtValor.getText());

					} catch (NumberFormatException nfe) {

						JOptionPane.showMessageDialog(Escalonamento.this,
								"Deverá ser um valor inteiro.");

					}

					okSelecionado = true;
					setVisible(false);

				}

			});

		}

		return btnOk;

	}

	private JButton getBtnCancelar() {

		if (btnCancelar == null) {

			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");

			btnCancelar.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {

					setVisible(false);

				}

			});

		}

		return btnCancelar;

	}

	public boolean alterarDados() {

		okSelecionado = false;
		setModal(true);
		setVisible(true);

		return okSelecionado;

	}

	public int getValor() {

		return Integer.parseInt(txtValor.getText());

	}

	public int getOrientacao() {

		String orientacao = cmbOrientacao.getSelectedItem().toString();

		if (orientacao.equals("Horizontal"))
			return 1;

		if (orientacao.equals("Vertical"))
			return 2;

		if (orientacao.equals("Ambos"))
			return 3;

		return 0;

	}

}
