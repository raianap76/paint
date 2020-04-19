//package controller;
//
//import java.awt.event.MouseEvent;
//import java.util.Vector;
//
//import model.AbstractFigura;
//import model.Ponto;
//import model.RetaDDA;
//import view.Janela.MeuJPanel;
//
//public class ControllerRetaDDA extends ControllerPlotar {
//
//	public ControllerRetaDDA(MeuJPanel jpanel,Vector<AbstractFigura> figuras) {
//		super(jpanel,figuras);
//		// TODO Auto-generated constructor stub
//	}
//	
//	public void mouseClicked(MouseEvent e) {
//		System.out.println("click controllerRetaDDA");
//		
//		pontos.add(new Ponto(e.getX(),e.getY()));
//		if(click != 0) {
//			figura = new RetaDDA(pontos.get(0),pontos.get(1));
//			figura.torneSeVisivel(jpanel.getGraphics());
//			click=0;
//		}
//		else if(click ==0)
//				click++;
//		
//	}
//
//}
