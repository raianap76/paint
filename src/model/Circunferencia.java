//package model;
//
//import java.awt.Graphics;
//
//import view.Janela.MeuJPanel;
//
//public class Circunferencia extends  AbstractFigura {
//
//	Ponto origem;
//	int raio;
//	
//	
//	public Circunferencia(Ponto origem,int raio) {
//		this.origem = origem;
//		this.raio = raio;
//	}
//	
//	@Override
//	public void torneSeVisivel(Graphics g) {
//		bresenhamCircunferencia(g);
//		
//	}
//	
//	private void plotPoints(MeuJPanel jpanel, int xc, int yc, int x, int y) {
//		jpanel.desenhar(xc+x, yc+y);
//		jpanel.desenhar(xc-x, yc+y);
//		jpanel.desenhar(xc+x, yc-y);
//		jpanel.desenhar(xc-x, yc-y);
//		jpanel.desenhar(xc+y, yc+x);
//		jpanel.desenhar(xc-y, yc+x);
//		jpanel.desenhar(xc+y, yc-x);
//		jpanel.desenhar(xc-y, yc-x);
//	}
//	
//	private void bresenhamCircunferencia(MeuJPanel jpanel) {
//
//		int xc = origem.getX() ,yc = origem.getY();
//		int x = 0,y = raio ,p = 3 - 2* raio;
//		plotPoints(jpanel,xc, yc, x, y);
//		
//		while(x < y) 
//		{
//			if(p < 0) 
//				p = p + 4 * x + 6;
//			else 
//			{
//				p = p + 4 * (x - y) + 10;
//				y= y -1;
//			}
//			x = x +1;
//			plotPoints(g,xc, yc, x, y);
//			
//		}
//	}
//
//}
