package edu.ibta.cg2.model;

import edu.ibta.cg2.componente.BarraStatus;

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

		isConvexo(pol);

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

		isConvexo(pol);

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

		isConvexo(pol);

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

		isConvexo(pol);

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

		isConvexo(pol);

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

		isConvexo(pol);

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

		isConvexo(pol);

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

		isConvexo(pol);

		return pol;
	}

	public static Poligono rotacao(Poligono poligono, int angulo) {

		int pix = 0;
		int piy = 0;

		String x;
		String y;

		pol = new Poligono();
		double angulo_rad = Math.toRadians(angulo);

		for (int i = 0; i < poligono.numeroPontos(); i++) {

			pontoX = poligono.retornaPonto(i).getX();
			pontoY = poligono.retornaPonto(i).getY();

			if (i == 0) {

				pix = pontoX;
				piy = pontoY;

			}

			x = ((pontoX * (Math.cos(angulo_rad))) - (pontoY * (Math
					.sin(angulo_rad)))) + "";

			y = ((pontoX * (Math.sin(angulo_rad))) + (pontoY * (Math
					.cos(angulo_rad)))) + "";

			pontoX = (int) Math.round(Double.parseDouble(x));
			pontoY = (int) Math.round(Double.parseDouble(y));

			ponto = new Ponto(pontoX, pontoY);
			pol.adicionaPonto(ponto);

		}

		pix -= pol.retornaPonto(0).getX();
		piy -= pol.retornaPonto(0).getY();

		translacao(pol, pix, piy);

		isConvexo(pol);

		return pol;

	}

	public static Poligono cisalhamento(Poligono poligono, int angulo,
			boolean orientacao) {

		int pix = 0;
		int piy = 0;
		
		pol = new Poligono();
		double angulo_rad = Math.toRadians(angulo);

		if (orientacao) {

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY();
				
				if(i == 0) {
					
					pix = pontoX;
					piy = pontoY;
					
				}

				pontoX = (int) (pontoX + pontoY * Math.tan(angulo_rad));

				ponto = new Ponto(pontoX, pontoY);

				pol.adicionaPonto(ponto);

			}

		}

		else {

			for (int i = 0; i < poligono.numeroPontos(); i++) {

				pontoX = poligono.retornaPonto(i).getX();
				pontoY = poligono.retornaPonto(i).getY();
				
				if(i == 0) {
					
					pix = pontoX;
					piy = pontoY;
					
				}


				pontoY = (int) (pontoY + pontoX * Math.tan(angulo_rad));

				ponto = new Ponto(pontoX, pontoY);

				pol.adicionaPonto(ponto);

			}

		}
		
		pix -= pol.retornaPonto(0).getX();
		piy -= pol.retornaPonto(0).getY();

		translacao(pol, pix, piy);

		isConvexo(pol);

		return pol;

	}

	public static Poligono isConvexo(Poligono p) {

		Ponto p1;
		Ponto p2;
		Ponto p3;

		int prev;
		int next;

		Poligono novo_poligono = new Poligono();

		for (int i = 0; i < p.numeroPontos(); i++) {

			p2 = p.retornaPonto(i);

			prev = i - 1;
			next = i + 1;

			if (prev == -1)
				prev = p.numeroPontos() - 1;
			if (next == p.numeroPontos())
				next = 0;

			p1 = p.retornaPonto(prev);
			p3 = p.retornaPonto(next);

			if (area(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(),
					p3.getY()) < 0)

				novo_poligono.adicionaPonto(new Ponto(p2.getX(), p2.getY(), 0));

			else
				novo_poligono.adicionaPonto(new Ponto(p2.getX(), p2.getY(), 1));

		}

		return novo_poligono;

	}

	private static double area(int x1, int y1, int x2, int y2, int x3, int y3) {

		double areaSum = 0;

		areaSum += x1 * (y3 - y2);
		areaSum += x2 * (y1 - y3);
		areaSum += x3 * (y2 - y1);

		return areaSum;

	}

	public static void areaTotal(Poligono p) {

		double area = 0;
		int j = p.numeroPontos() - 1;

		for (int i = 0; i < p.numeroPontos(); i++) {

			area += (p.retornaPonto(j).getX() + p.retornaPonto(i).getX())
					* (p.retornaPonto(j).getY() - p.retornaPonto(i).getY());
			j = i;

		}

		if (area < 0)
			area *= (-1);

		BarraStatus.atualArea(area / 2);

	}

}
