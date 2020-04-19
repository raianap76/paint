package model;

import java.awt.Graphics;

import view.Janela.MeuJPanel;

public class RetaBresenham extends Reta{
	
	public RetaBresenham() {}
	
	public RetaBresenham(Ponto p1, Ponto p2) {
		super(p1, p2);
	}
	
	@Override
	public void torneSeVisivel(Graphics g) {
//		System.out.println("executando bresenham");
		bresenham(g);
		
	}

	private void bresenham(Graphics g) 
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
		g.drawLine(x, y, x, y);
		
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
				
					g.drawLine(x, y, x, y);
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
					g.drawLine(x, y, x, y);
			}
		}
	}

	
}
