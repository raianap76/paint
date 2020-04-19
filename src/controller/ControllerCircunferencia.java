//package controller;
//
//import java.awt.event.MouseEvent;
//import java.util.Vector;
//
//import model.Circunferencia;
//import model.Ponto;
//import view.Janela.MeuJPanel;
//
//public class ControllerCircunferencia extends ControllerPlotar {
//
//	public ControllerCircunferencia(MeuJPanel jpanel) {
//		super(jpanel);
//	}
//	
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		System.out.println("click controllerCircunferencia");
//		
//		pontos.add(new Ponto(e.getX(),e.getY()));
//		if(click != 0) {
//			
//			int raio = calcularRaio(pontos);
//			figura =  new Circunferencia(pontos.get(0),raio);
//			figura.torneSeVisivel(jpanel);
//			click=0;
//			pontos.removeAllElements();
//		}
//		else if(click ==0)
//				click++;
//		
//	}
//	
//	private int calcularRaio(Vector<Ponto> pontos) {
//		
//		int xc = pontos.get(0).getX(), yc = pontos.get(0).getY();
//		int x = pontos.get(1).getX(), y = pontos.get(1).getY();
//		
//		return (int) Math.sqrt( Math.pow(x - xc,2) + Math.pow(y - yc,2) ) ;
//	}
//}
