package edu.ibta.cg2.arquivos;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ibta.cg2.componente.AreaPrincipal;

public class SalvarArquivo {

	/**
	 * Disponibiliza a tela para salvar um arquivo.
	 * 
	 */
	public static void salva() {

		ManipuladorXML mxml = new ManipuladorXML();
		
		try {

			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter(".AUT", "aut"));
			int retorno = chooser.showSaveDialog(null);
			String nomeArquivo = chooser.getSelectedFile().getAbsolutePath();

			if (!nomeArquivo.endsWith(".aut"))
				nomeArquivo += ".aut";

			if (retorno == JFileChooser.APPROVE_OPTION) {

				FileWriter fw = new FileWriter(nomeArquivo);

				fw.write(mxml.salva(AreaPrincipal.poligono));

				fw.close();

			}
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
	}
}
