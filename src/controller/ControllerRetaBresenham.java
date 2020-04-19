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
	Boolean inicioReta,desenhar,fimReta;
	String nomeClass;
	Reta reta;
	
	
	public ControllerRetaBresenham(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
		super(jpanel,figuras);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click controllerRetaBresenham");
		
////		pontos.add(new Ponto(e.getX(),e.getY()));
//		if(click != 0) {
////			figura = new RetaBresenham(pontos.get(0),pontos.get(1));
//			figura.torneSeVisivel(jpanel);
//			click=0;
////			pontos.removeAllElements();
//		}
//		else if(click ==0)
//				click++;
//		
	}
//	
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
//		System.out.println("merda");
		if(fimReta) {
			inicioReta = true;
			fimReta = false;
			desenhar = false;
			jpanel.repintarTela();
			paint(jpanel.getGraphics());
			p2 = new Ponto(e.getX(),e.getY());
				
			reta.setP1(p1);
			reta.setP2(p2);
			
//			figuras.add(new RetaBresenham(p1,p2));
			
//			Object obj = null;
//			try {
//				
//				obj = Class.forName("model.RetaBresenham").newInstance();
//			} catch (InstantiationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
//			Reta reta = (Reta)obj;
//			
			reta.setP1(p1);
			reta.setP2(p2);
			
			figuras.add(reta);
			figuras.get(figuras.size()-1).torneSeVisivel(jpanel.getGraphics());
			
			figuras.get(figuras.size()-1).torneSeVisivel(jpanel.getGraphics());
		
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		jpanel.setFocusable(true);
        jpanel.requestFocusInWindow();
		
		if(desenhar) 
		{
			jpanel.repintarTela();
			paint(jpanel.getGraphics());
			fimReta=true;
			Graphics g = jpanel.getGraphics();
			g.drawLine(e.getX(),e.getY(), p1.getX(), p1.getY());
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action");
		inicioReta=true;
		fimReta=false;
		jpanel.addMouseListener(this);
		jpanel.addMouseMotionListener(this);
		
		nomeClass = e.getActionCommand();
		
		if(nomeClass.equals("reta bresenham")) 
		{
			System.out.println(nomeClass);
			reta = new RetaBresenham();
		}
		else 
		{
			System.out.println(nomeClass);
			reta = new RetaDDA(); 
		}
		
	}
	
	
}
