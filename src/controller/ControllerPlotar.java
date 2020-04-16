package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import model.AbstractFigura;
import model.Ponto;
import view.Janela.MeuJPanel;

abstract public class ControllerPlotar implements MouseListener,ActionListener {
	
	protected MeuJPanel jpanel; 
	protected AbstractFigura figura;
	protected int click = 0;
	protected Vector<Ponto> pontos;
	
	public ControllerPlotar(Container conteiner,MeuJPanel jpanel) {
		conteiner.addMouseListener(this);
		this.jpanel = jpanel;
		pontos = new Vector<Ponto>();
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
		// TODO Auto-generated method stub	
	}
	@Override
	public void mousePressed(MouseEvent e) {					
				
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
