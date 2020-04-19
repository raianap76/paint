package model;

import java.awt.Graphics;

public class Retangulo extends AbstractFigura {

	Ponto p1,p2,p3,p4;
	
	
	public Retangulo(Ponto v1, Ponto v3) {
		this.p1 = v1;
		this.p3 = v3;
		this.p2 = new Ponto(p3.x,p1.y);
		this.p4 = new Ponto(p1.x,p3.y);
	}
	
	@Override
	public void torneSeVisivel(Graphics g) {
		new RetaBresenham(p1,p4).torneSeVisivel(g);
		new RetaBresenham(p1,p2).torneSeVisivel(g);
		new RetaBresenham(p3,p4).torneSeVisivel(g);
		new RetaBresenham(p3,p2).torneSeVisivel(g);
		
	}

}
