package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import model.AbstractFigura;
import model.Ponto;
import model.Reta;
import view.Janela.MeuJPanel;

public class ControllerPlotar implements MouseListener {
	
	private MeuJPanel jpanel; 
	private AbstractFigura figura;
	private int figure;
	

	private int click = 0;
	
	private Vector<Ponto> pontos;
	
//	private Vector<AFigure> figuras;
	
	public ControllerPlotar() {
//		figuras = new Vector<AFigure>();
		pontos = new Vector<Ponto>();
	}

	public void setFigure(int wFigure ) {
		this.figure = figure;
	}
	
	public void setJPanel(MeuJPanel jpanel){
		this.jpanel = jpanel;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(figure == 0) {
			pontos.add(new Ponto(e.getX(),e.getY()));
			if(click != 0) {
				figura = new Reta(pontos.get(0),pontos.get(1));
				figura.torneSeVisivel(jpanel);
				click=0;
				pontos.removeAllElements();
			}
			else if(click ==0)
					click++;
		}
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
		
		
//		jpanel.desenhar(1, 1);
					
				
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
