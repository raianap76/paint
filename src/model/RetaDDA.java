package model;

import java.awt.Graphics;

import view.Janela.MeuJPanel;

public class RetaDDA extends Reta {

	public RetaDDA() {}
	 
	public RetaDDA(Ponto p1, Ponto p2) {
		super(p1, p2);
	}
	
	@Override
	public void torneSeVisivel(Graphics g) {
//		System.out.println("Executando dda");
		dda(g);
		
	}
	private void dda(Graphics g) {
		
		
		int dx,dy, passos,k;
		float incrx,incry,x,y;
		
		int x1 = p1.getX(), x2 = p2.getX();
		int y1 = p1.getY(), y2 = p2.getY();
		
		dx = x2 - x1;
		dy = y2 - y1;
		
		if(Math.abs(dx) > Math.abs(dy))
			passos = Math.abs(dx);
		else
			passos = Math.abs(dy);
		incrx = dx / passos;
		incry = dy / passos;
		x = x1; y = y1;
		
		g.drawLine(Math.round(x), Math.round(y),Math.round(x), Math.round(y));
		
		for(k = 1; k < passos; k++) 
		{
			g.drawLine(Math.round(x), Math.round(y),Math.round(x), Math.round(y));
			x = x + incrx;
			y = y + incry;
			
		}
		
	}
}
