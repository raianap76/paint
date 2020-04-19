package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import model.AbstractFigura;
import view.Janela.MeuJPanel;

 abstract public class ControllerPlotar implements MouseListener,MouseMotionListener {
	
	protected MeuJPanel jpanel; 
	protected AbstractFigura figura;
	protected int click = 0;
	protected Vector<AbstractFigura> figuras;
	
	public ControllerPlotar(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
		this.jpanel = jpanel;
		this.figuras = figuras;
		
	}
	
	public void setJPanel(MeuJPanel jpanel){
		this.jpanel = jpanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		repintarTela();
	}
	@Override
	public void mousePressed(MouseEvent e) {					
				
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
