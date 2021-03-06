package model;

import java.awt.Graphics;

public class Ponto extends AbstractFigura{
	int x,y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		
		String str ="p:" +
	               this.x +
	               ":" +
	               this.y;
		
		return str;
	}

	@Override
	public void torneSeVisivel(Graphics g) {
		g.drawLine (this.x-1,this.y-1,this.x,this.y);
	}
		
}
