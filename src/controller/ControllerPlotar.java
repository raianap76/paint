package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import model.AbstractFigura;
import model.Circunferencia;
import model.Ponto;
import model.RetaBresenham;
import model.RetaDDA;
import model.Retangulo;
import view.Janela.MeuJPanel;

public class ControllerPlotar implements MouseListener,MouseMotionListener {
	
	private MeuJPanel jpanel; 
	private Vector<AbstractFigura> figuras;
	
	Ponto p1,p2;
	Boolean inicioReta = true,desenhar,fimReta=false;
	String nomeClass;
	AbstractFigura figura;
	
	
	public ControllerPlotar(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
		this.jpanel = jpanel;
		this.figuras = figuras;
		
	}
	
	public void setJPanel(MeuJPanel jpanel){
		this.jpanel = jpanel;
	}
	
	public void setNomeClass(String nomeClass) {
		this.nomeClass = nomeClass;
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
				else if(nomeClass.equals("retangulo"))
					figura = new Retangulo(p1,p2);
				else
					figura = new Circunferencia(p1,p2);
					
			
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
			
			if(nomeClass.equals("bresenham"))
				figura = new RetaBresenham(new Ponto(e.getX(),e.getY()),p1);
			else
				if(nomeClass.equals("dda"))
					figura = new RetaDDA(new Ponto(e.getX(),e.getY()),p1);
				else if(nomeClass.equals("retangulo"))
					figura = new Retangulo(new Ponto(e.getX(),e.getY()),p1);
				else
					figura = new Circunferencia(new Ponto(e.getX(),e.getY()),p1); 
			figura.torneSeVisivel(jpanel.getGraphics());
//			Graphics g = jpanel.getGraphics();
//			g.drawLine(e.getX(),e.getY(), p1.getX(), p1.getY());
			
		}
	}
	protected void paint (Graphics g) {
        for (int i=0 ; i<figuras.size(); i++)
            figuras.get(i).torneSeVisivel(g);
    }
	public void repintarTela() {

//        try{
//            Thread.sleep(1);                 //1000 milliseconds is one second.
//        } catch(InterruptedException ex) {
//            Thread.currentThread().interrupt();
//        }
//        

        jpanel.resize(jpanel.getHeight()+1, jpanel.getWidth()+1);
        jpanel.resize(jpanel.getHeight()-1, jpanel.getWidth()-1);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
