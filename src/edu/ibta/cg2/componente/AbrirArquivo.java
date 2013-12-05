package edu.ibta.cg2.componente;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AbrirArquivo {

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
