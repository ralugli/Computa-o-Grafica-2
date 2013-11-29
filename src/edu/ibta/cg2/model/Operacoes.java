package edu.ibta.cg2.model;


public class Operacoes {

	private static int pontoX;
	private static int pontoY;
	private static Poligono pol;
	private static Ponto ponto;

	/**
	 * @param poligono
	 * @param orientacao
	 * @return
	 * 
	 *         Se orientacao for 'true', horizontal; caso contrario, na
	 *         vertical;
	 */
	public static Poligono espelhamento(Poligono poligono, boolean orientacao) {

		pol = new Poligono();

		if (orientacao) {
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoX = poligono.retornaPonto(i).getX() - 1;
				pontoY = poligono.retornaPonto(i).getY();
				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);
			}
		} else {
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY() - 1;
				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);
			}
		}

		return pol;

	}

	public static Poligono espelhamento(Poligono poligono) {

		pol = new Poligono();

		for (int i = 0; i < poligono.numeroPontos(); i++) {
			pontoX = poligono.retornaPonto(i).getX() - 1;
			pontoY = poligono.retornaPonto(i).getY() - 1;
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);
		}

		return pol;
	}

	public static Poligono translacao(Poligono poligono, int distancia,
			boolean orientacao) {

		pol = new Poligono();

		if (orientacao) {
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoX = poligono.retornaPonto(i).getX() + distancia;
				pontoY = poligono.retornaPonto(i).getY();
				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);
			}
		} else {
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY() + distancia;
				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);
			}
		}

		return pol;
	}

	public static Poligono translacao(Poligono poligono, int distanciaX,
			int distanciaY) {

		pol = new Poligono();
		for (int i = 0; i < poligono.numeroPontos(); i++) {
			pontoX = poligono.retornaPonto(i).getX() + distanciaX;
			pontoY = poligono.retornaPonto(i).getY() + distanciaY;
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);
		}
		return pol;
	}

	public static Poligono translacao(Poligono poligono, int distancia) {

		pol = new Poligono();
		
		for (int i = 0; i < poligono.numeroPontos(); i++) {
			pontoX = poligono.retornaPonto(i).getX() + distancia;
			pontoY = poligono.retornaPonto(i).getY() + distancia;
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);
		}
		return pol;
	}

	public static Poligono escalonamento(Poligono poligono, int dimensao,
			boolean orientacao) {

		pol = new Poligono();

		if (orientacao) {
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoX = poligono.retornaPonto(i).getX() * dimensao;
				pontoY = poligono.retornaPonto(i).getY();
				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);
			}
		} else {
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY() * dimensao;
				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);
			}
		}

		return pol;
	}

	public static Poligono escalonamento(Poligono poligono, int dimensaoX,
			int dimensaoY) {

		pol = new Poligono();

		for (int i = 0; i < poligono.numeroPontos(); i++) {
			pontoX = poligono.retornaPonto(i).getX() * dimensaoX;
			pontoY = poligono.retornaPonto(i).getY() * dimensaoY;
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);
		}

		return pol;
	}

	public static Poligono escalonamento(Poligono poligono, int dimensao) {

		pol = new Poligono();

		for (int i = 0; i < poligono.numeroPontos(); i++) {
			pontoX = poligono.retornaPonto(i).getX() * dimensao;
			pontoY = poligono.retornaPonto(i).getY() * dimensao;
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);
		}

		return pol;
	}
	public static Poligono rotacao(Poligono poligono, int angulo) {
		
		pol = new Poligono();
		double angulo_rad = Math.sin(Math.toRadians(angulo));
		
		
		for (int i = 0; i < poligono.numeroPontos(); i++) {
			
		
					
			pontoX = (int) ((int) (poligono.retornaPonto(i).getX() * (Math.cos(angulo_rad))) - (poligono.retornaPonto(i).getY() * (Math.sin(angulo_rad))));
			pontoY = (int) ((int) (poligono.retornaPonto(i).getX() * (Math.sin(angulo_rad))) + (poligono.retornaPonto(i).getY() * (Math.cos(angulo_rad))
				));
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);
		}
		
		return pol;
	}

	public static Poligono cisalhamento(Poligono poligono, boolean orientacao, int angulo){
		//se vier positivo, é horizontal, caso contrário vertical
		pol = new Poligono();
		double angulo_rad = Math.sin(Math.toRadians(angulo));
		
		if (orientacao) {
			
		
		for (int i = 0; i < poligono.numeroPontos(); i++) {
			pontoX = (int) (pontoX + pontoY * Math.tan(angulo_rad));
		}
		
		return pol;
		
		}
		
		else {
			
			for (int i = 0; i < poligono.numeroPontos(); i++) {
				pontoY = (int) (pontoY + pontoX * Math.tan(angulo_rad));
			}
			
			return pol;
			
		}
	}
	
	//x = x + y * tan(y); formulas nao matriciais;
	//y = y + x * tan(x);
}
