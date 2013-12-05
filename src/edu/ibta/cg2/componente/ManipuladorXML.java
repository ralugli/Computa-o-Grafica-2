package edu.ibta.cg2.componente;

import java.io.Reader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import edu.ibta.cg2.model.Poligono;
import edu.ibta.cg2.model.Ponto;

public class ManipuladorXML {

	private XStream stream;

	public ManipuladorXML() {

		stream = new XStream(new DomDriver());
		stream.autodetectAnnotations(true);
		stream.alias("Ponto", Ponto.class);
		stream.alias("Poligono", Poligono.class);

	}

	public Poligono carrega(Reader fonte) {

		return (Poligono) (stream.fromXML(fonte));

	}

	public String salva(Poligono poligono) {

		return stream.toXML(poligono);

	}
}
