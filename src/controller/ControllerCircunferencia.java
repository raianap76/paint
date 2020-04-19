package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import model.AbstractFigura;
import model.Circunferencia;
import model.Ponto;
import view.Janela.MeuJPanel;

public class ControllerCircunferencia extends ControllerPlotar {

	Vector<Ponto>  pontos = new Vector<Ponto>();
	public ControllerCircunferencia(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
		super(jpanel,figuras);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click controllerCircunferencia");
		
		pontos.add(new Ponto(e.getX(),e.getY()));
		if(click != 0) {
			
			
			int raio = calcularRaio(pontos);
			figura =  new Circunferencia(pontos.get(0),raio);
			figura.torneSeVisivel(jpanel.getGraphics());
			click=0;
			pontos.removeAllElements();
		}
		else if(click ==0)
				click++;
		
	}
	
	
	private int calcularRaio(Vector<Ponto> pontos) {
		
		int xc = pontos.get(0).getX(), yc = pontos.get(0).getY();
		int x = pontos.get(1).getX(), y = pontos.get(1).getY();
		
		//Calculando o ponto do meio para calcular o raio
		xc = (xc + x)/2;
		yc = (yc + y)/2;
		
		//atualizando o poonto do meio da circunferencia
		pontos.get(0).setX(xc);
		pontos.get(0).setY(yc);
		
		return (int) Math.sqrt( Math.pow(x - xc,2) + Math.pow(y - yc,2) ) ;
	}
	
public void actionPerformed(ActionEvent e) {
		
	}
}
