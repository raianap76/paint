package model;

import view.Janela.MeuJPanel;

public class Reta extends AbstractFigura {

	Ponto p1,p2;
	
	public Reta(Ponto p1, Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public void setPontos(Ponto p1, Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Ponto getP1() {
		return p1;
	}

	public void setP1(Ponto p1) {
		this.p1 = p1;
	}

	public Ponto getP2() {
		return p2;
	}

	public void setP2(Ponto p2) {
		this.p2 = p2;
	}

	@Override
	public void torneSeVisivel(MeuJPanel jpanel) {		
		bresenham(jpanel);
	}
	
	
	private void bresenham(MeuJPanel jpanel) 
	{
		int x1,x2;
		int y1,y2;
		int x,y,dx,dy,i,const1,const2,p;
		int incrx,incry;
		
		x1=p1.getX();
		x2=p2.getX();
		y1=p1.getY();
		y2=p2.getY();
		
		dx = x2 - x1;
		dy = y2 - y1;
		
		if(dx>=0)
			incrx =1;
		else {incrx = -1; dx = -dx;}
		if(dy >=0)
			incry = 1;
		else {incry = -1; dy = -dy;}
		
		x = x1; y = y1;
		jpanel.desenhar(x, y);
		
		if(dy < dx) 
		{
			p = 2*dy-dx;
			const1 = 2*dy;
			const2 = 2*(dy-dx);
			for(i =0; i < dx; i++) 
			{
				x+=incrx;
				if(p < 0)
					p+=const1;
				else 
					y+=incry; p+=const2;
				
				jpanel.desenhar(x, y);
			}
		}
		else
		{
			p =2*dx - dy; const1 = 2*dx; const2 = 2*(dx-dy);
			
			for(i = 0; i < dy;i++) 
			{
				y+=incry;
				if(p<0)
					p+=const1;
				else
					x+=incrx; p+=const2;
				jpanel.desenhar(x, y);
			}
		}
	}
	
}
