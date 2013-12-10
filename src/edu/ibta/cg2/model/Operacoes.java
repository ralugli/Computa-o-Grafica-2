package edu.ibta.cg2.model;

public class Operacoes {

	private static int pontoX;
	private static int pontoY;
	private static Poligono pol;
	private static Ponto ponto;

	/**
	 * @param poligono
	 * @param orientacao
	 *            Se orientacao for 'true', horizontal; caso contrario, na
	 *            vertical;
	 */
	public static Poligono espelhamento(Poligono poligono, boolean orientacao) {

		int pix = 0;
		int piy = 0;

		pol = new Poligono();

		if (orientacao) {

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY();

				if (i == 0) {

					pix = pontoX;
					piy = pontoY;

				}

				pontoX = pontoX * (-1);

				ponto = new Ponto(pontoX, pontoY);

				pol.adicionaPonto(ponto);

			}

			pix = 2 * pix;
			pol = translacao(pol, pix, true);

		} else {

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY();

				if (i == 0) {

					pix = pontoX;
					piy = pontoY;

				}

				pontoY = pontoY * (-1);

				ponto = new Ponto(pontoX, pontoY);
				pol.adicionaPonto(ponto);

			}

			piy = 2 * piy;
			pol = translacao(pol, piy, false);

		}

		return pol;

	}

	public static Poligono espelhamento(Poligono poligono) {

		int pix = 0;
		int piy = 0;

		pol = new Poligono();

		for (int i = 0; i < poligono.numeroPontos(); i++) {

			pontoX = poligono.retornaPonto(i).getX();
			pontoY = poligono.retornaPonto(i).getY();

			if (i == 0) {

				pix = pontoX;
				piy = pontoY;

			}

			pontoX = pontoX * (-1);
			pontoY = pontoY * (-1);

			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);

		}
		
		pix = 2 * pix;
		piy = 2 * piy;
		
		pol = translacao(pol, pix, piy);

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

			pontoX = (int) ((int) (poligono.retornaPonto(i).getX() * (Math
					.cos(angulo_rad))) - (poligono.retornaPonto(i).getY() * (Math
					.sin(angulo_rad))));
			pontoY = (int) ((int) (poligono.retornaPonto(i).getX() * (Math
					.sin(angulo_rad))) + (poligono.retornaPonto(i).getY() * (Math
					.cos(angulo_rad))));
			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);

		}

		return pol;

	}

	public static Poligono cisalhamento(Poligono poligono, int angulo,
			boolean orientacao) {

		pol = new Poligono();
		double angulo_rad = Math.sin(Math.toRadians(angulo));

		if (orientacao) {

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY();

				pontoX = (int) (pontoX + pontoY * Math.tan(angulo_rad));

				ponto = new Ponto(pontoX, pontoY);

				pol.adicionaPonto(ponto);

			}

			return pol;

		}

		else {

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY();

				pontoY = (int) (pontoY + pontoX * Math.tan(angulo_rad));

				ponto = new Ponto(pontoX, pontoY);

				pol.adicionaPonto(ponto);

			}

			return pol;

		}

	}

}
