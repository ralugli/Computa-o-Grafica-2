package edu.ibta.cg2.componente;

import java.io.Reader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class ManipuladorXML {

	private XStream stream;

	/**
	 * Cria a estrutura para manipular XML, como alias para classes e detectação
	 * de anotações das mesmas.
	 */
	public ManipuladorXML() {

		stream = new XStream(new DomDriver());
		stream.autodetectAnnotations(true);
		stream.alias("Ponto", Ponto.class);
		stream.alias("Poligono", Poligono.class);

	}

	/**
	 * Carrega o conteúdo, em XML, do arquivo citado pelo fonte e retorna um
	 * Poligono.
	 * 
	 * @param fonte
	 *            tipo Reader, é o arquivo a ser lido.
	 * @return Retorna Poligono para as devidas manipulações.
	 */
	public Poligono carrega(Reader fonte) {

		return (Poligono) (stream.fromXML(fonte));

	}

	/**
	 * Salva o conteúdo de um Poligono no formato XML e retorna uma String para
	 * manipulação.
	 * 
	 * @param poligono
	 *            tipo Poligono, passa uma lista de pontos para serem
	 *            transformados no formato XML.
	 * @return Retorna String para as devidas manipulações.
	 */
	public String salva(Poligono poligono) {

		return stream.toXML(poligono);

	}
}
