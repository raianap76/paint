package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerCircunferencia;
import controller.ControllerPlotar;
import controller.ControllerRetaBresenham;
import model.AbstractFigura;
import javax.swing.JMenuBar;


public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MeuJPanel meuJPanel = new MeuJPanel();
	private Vector<AbstractFigura> figuras = new Vector<AbstractFigura>();
	
	JButton btnRetaBresenham = new JButton("reta bresenham");
	JButton btnRetaDDA = new JButton("reta dda");
	JButton btnCircunferencia = new JButton("circunferencia");
	
	
	ControllerRetaBresenham controllerPlotarRetaBresenham;
	ControllerRetaBresenham controllerPlotarRetaDDA;


	/**
	 * Create the frame.
	 */
	public Janela() {
		super();
		Container cntForm;
		
		cntForm = this.getContentPane();
		cntForm.setLayout (new BorderLayout());
		cntForm.add (meuJPanel,  BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
		
		
		menuBar.add(btnRetaBresenham);
		menuBar.add(btnRetaDDA);
		menuBar.add(btnCircunferencia);
		
		meuJPanel.add(menuBar);
		
//		btnCircunferencia.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				ControllerPlotar controllerPlotarCirc = new ControllerCircunferencia(meuJPanel,figuras);
//				cntForm.addMouseListener(controllerPlotarCirc);
//				cntForm.addMouseMotionListener(controllerPlotarCirc);
//			}
//		});
		
        
		controllerPlotarRetaBresenham = new ControllerRetaBresenham(meuJPanel,figuras);
        btnRetaBresenham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				controllerPlotarRetaBresenham.repintarTela();
//				cntForm.removeMouseListener(controllerPlotarRetaDDA);
//				cntForm.removeMouseMotionListener(controllerPlotarRetaDDA);
				controllerPlotarRetaBresenham.setNomeClass("bresenham");
				meuJPanel.removeMouseListener(controllerPlotarRetaDDA);
				meuJPanel.removeMouseMotionListener(controllerPlotarRetaDDA);
				meuJPanel.addMouseMotionListener(controllerPlotarRetaBresenham);
				meuJPanel.addMouseListener(controllerPlotarRetaBresenham);
//				cntForm.addMouseListener(controllerPlotarRetaBresenham);
//				cntForm.addMouseMotionListener(controllerPlotarRetaBresenham);
//				controllerPlotarRetaBresenham.repintarTela();
			}
		});
		
        controllerPlotarRetaDDA = new ControllerRetaBresenham(meuJPanel,figuras);
		btnRetaDDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				cntForm.removeMouseListener(controllerPlotarRetaBresenham);
//				cntForm.removeMouseMotionListener(controllerPlotarRetaBresenham);
				controllerPlotarRetaDDA.setNomeClass("dda");
				meuJPanel.removeMouseListener(controllerPlotarRetaBresenham);
				meuJPanel.removeMouseMotionListener(controllerPlotarRetaBresenham);
				meuJPanel.addMouseMotionListener(controllerPlotarRetaDDA);
				meuJPanel.addMouseListener(controllerPlotarRetaDDA);
//				cntForm.addMouseListener(controllerPlotarRetaDDA);
//				cntForm.addMouseMotionListener(controllerPlotarRetaDDA);
//				meuJPanel.repintarTela();
			}
		});
		
		this.setSize (1024,768);
        this.setVisible (true);
		
	}

	public class MeuJPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public MeuJPanel() {
			super();	
		}
		public void desenhar(int x, int y) {
			
			meuJPanel.getGraphics().setColor(Color.BLACK);
			meuJPanel.getGraphics().drawLine(x, y, x, y);
		}
		public void paintT(Graphics g) {
	        for (int i=0; i<figuras.size(); i++)
	            figuras.get(i).torneSeVisivel(g);
	    }
		
		@SuppressWarnings("deprecation")
		public void repintarTela(int x) {

	        try{
	            Thread.sleep(x);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
	        

	        meuJPanel.resize(meuJPanel.getHeight()+1, meuJPanel.getWidth()+1);
	        meuJPanel.resize(meuJPanel.getHeight()-1, meuJPanel.getWidth()-1);
		}
		
	}
}
