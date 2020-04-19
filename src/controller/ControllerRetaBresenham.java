package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import model.AbstractFigura;
import model.Ponto;
import model.Reta;
import model.RetaBresenham;
import model.RetaDDA;
import view.Janela.MeuJPanel;


public class ControllerRetaBresenham extends ControllerPlotar {
	
	Ponto p1,p2;
	Boolean inicioReta = true,desenhar,fimReta=false;
	String nomeClass;
	Reta reta;
	
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
//			repintarTela();
			p2 = new Ponto(e.getX(),e.getY());
				
			if(nomeClass.equals("bresenham"))
				reta = new RetaBresenham(p1,p2);
			else
				reta = new RetaDDA(p1,p2);
			
			figuras.add(reta);
			figuras.get(figuras.size()-1).torneSeVisivel(jpanel.getGraphics());
			p1 = p2 = null;
			jpanel.paintT(jpanel.getGraphics());
		
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
			Graphics g = jpanel.getGraphics();
			g.drawLine(e.getX(),e.getY(), p1.getX(), p1.getY());
			
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
