package controller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import model.AbstractFigura;
import model.Ponto;
import model.RetaBresenham;
import model.RetaDDA;
import model.Retangulo;
import view.Janela.MeuJPanel;


public class ControllerRetaBresenham extends ControllerPlotar {
	
	Ponto p1,p2;
	Boolean inicioReta = true,desenhar,fimReta=false;
	String nomeClass;
	AbstractFigura figura;
	
	public void setNomeClass(String nomeClass) {
		this.nomeClass = nomeClass;
	}

	public ControllerRetaBresenham(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
		super(jpanel,figuras);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed bresenham");
		if(inicioReta) 
		{
			System.out.println("inicio");
			inicioReta = false;
			desenhar = true;
			p1 = new Ponto(e.getX(),e.getY());
		} 
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("merda");
		if(fimReta) {
			inicioReta = true;
			fimReta = false;
			desenhar = false;
			p2 = new Ponto(e.getX(),e.getY());
				
			if(nomeClass.equals("bresenham"))
				figura = new RetaBresenham(p1,p2);
			else
				if(nomeClass.equals("dda"))
					figura = new RetaDDA(p1,p2);
				else 
				{
					figura = new Retangulo(p1,p2);
				}
					
			
			figuras.add(figura);
			figuras.get(figuras.size()-1).torneSeVisivel(jpanel.getGraphics());
			p1 = p2 = null;
			paint(jpanel.getGraphics());
		
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		jpanel.setFocusable(true);
        jpanel.requestFocusInWindow();
		
		if(desenhar) 
		{
			repintarTela();
			fimReta=true;
//			Graphics g = jpanel.getGraphics();
//			g.drawLine(e.getX(),e.getY(), p1.getX(), p1.getY());
			
		}
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("action");
//		inicioReta=true;
//		fimReta=false;
//		jpanel.addMouseListener(this);
//		jpanel.addMouseMotionListener(this);
//		
//		nomeClass = e.getActionCommand();
//		
//		if(nomeClass.equals("reta bresenham")) 
//		{
//			System.out.println(nomeClass);
//			reta = new RetaBresenham();
//		}
//		else 
//		{
//			System.out.println(nomeClass);
//			reta = new RetaDDA(); 
//		}
//		
//	}
	
	
}
