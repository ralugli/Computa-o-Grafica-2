package edu.ibta.cg2.arquivos;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ibta.cg2.componente.AreaPrincipal;

public class AbrirArquivo {

	/**
	 * Disponibiliza a tela para abrir um arquivo.
	 * 
	 */
	public static void escolhe() {

		ManipuladorXML mxml = new ManipuladorXML();

		try {

			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter(".AUT", "aut"));
			int retorno = chooser.showOpenDialog(null);

			if (retorno == JFileChooser.APPROVE_OPTION) {

				FileReader reader = new FileReader(chooser.getSelectedFile());
				AreaPrincipal.poligono = mxml.carrega(reader);

			}
		} catch (FileNotFoundException e) {

			System.out.println("e");

		}
	}
}
