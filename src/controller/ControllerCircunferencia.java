//package controller;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseEvent;
//import java.util.Vector;
//
//import model.AbstractFigura;
//import model.Circunferencia;
//import model.Ponto;
//import view.Janela.MeuJPanel;
//
//public class ControllerCircunferencia extends ControllerPlotar {
//
//	Vector<Ponto>  pontos = new Vector<Ponto>();
//	public ControllerCircunferencia(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
//		super(jpanel,figuras);
//	}
//	
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		System.out.println("click controllerCircunferencia");
//		
//		pontos.add(new Ponto(e.getX(),e.getY()));
//		if(click != 0) {
//			
//			
//			int raio = calcularRaio(pontos);
//			figura =  new Circunferencia(pontos.get(0),raio);
//			figura.torneSeVisivel(jpanel.getGraphics());
//			figuras.add(figura);
//			click=0;
//			pontos.removeAllElements();
//			paint(jpanel.getGraphics());
//		}
//		else if(click ==0)
//				click++;
//		
//	}
//	
//	
//}
