package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.ControllerPlotar;
import model.AbstractFigura;


public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MeuJPanel meuJPanel = new MeuJPanel();
	private Vector<AbstractFigura> figuras = new Vector<AbstractFigura>();
	
	private final JButton btnRetaBresenham = new JButton("reta bresenham");
	private final JButton btnRetaDDA = new JButton("reta dda");
	private final JButton btnCircunferencia = new JButton("circunferencia");
	private final JButton btnRetangulo = new JButton("retangulo");
	
	ControllerPlotar controllerPlotarRetaBresenham;
	ControllerPlotar controllerPlotarRetaDDA;
	ControllerPlotar controllerRetangulo;
	ControllerPlotar controllerPlotarCircunferencia;


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
		setJMenuBar(menuBar);
		
		
		menuBar.add(btnRetaBresenham);
		menuBar.add(btnRetaDDA);
		menuBar.add(btnCircunferencia);
		menuBar.add(btnRetangulo);
		
		
		
		btnRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllListener();
				controllerRetangulo = new ControllerPlotar(meuJPanel,figuras);
				controllerRetangulo.setNomeClass("retangulo");
				meuJPanel.addMouseMotionListener(controllerRetangulo);
				meuJPanel.addMouseListener(controllerRetangulo);
			}
		});
		
		
		
//		meuJPanel.add(menuBar);
		
		btnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAllListener();
				controllerPlotarCircunferencia = new ControllerPlotar(meuJPanel,figuras);
				controllerPlotarCircunferencia.setNomeClass("circunferencia");
				meuJPanel.addMouseListener(controllerPlotarCircunferencia);
				meuJPanel.addMouseMotionListener(controllerPlotarCircunferencia);
			}
		});
		
        
		
        btnRetaBresenham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllListener();
				controllerPlotarRetaBresenham = new ControllerPlotar(meuJPanel,figuras);
				controllerPlotarRetaBresenham.setNomeClass("bresenham");
				meuJPanel.addMouseMotionListener(controllerPlotarRetaBresenham);
				meuJPanel.addMouseListener(controllerPlotarRetaBresenham);

			}
		});
		
        
		btnRetaDDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllListener();
				controllerPlotarRetaDDA = new ControllerPlotar(meuJPanel,figuras);
				controllerPlotarRetaDDA.setNomeClass("dda");
				meuJPanel.addMouseMotionListener(controllerPlotarRetaDDA);
				meuJPanel.addMouseListener(controllerPlotarRetaDDA);}
		});
		
		this.setSize (1024,768);
        this.setVisible (true);
		
	}
	
	public void removeAllListener() {
		
		
		meuJPanel.removeMouseListener(controllerPlotarRetaBresenham);
		meuJPanel.removeMouseMotionListener(controllerPlotarRetaBresenham);
		
		meuJPanel.removeMouseListener(controllerPlotarRetaDDA);
		meuJPanel.removeMouseMotionListener(controllerPlotarRetaDDA);
		
		meuJPanel.removeMouseListener(controllerRetangulo);
		meuJPanel.removeMouseMotionListener(controllerRetangulo);
		
		meuJPanel.removeMouseListener(controllerPlotarCircunferencia);
		meuJPanel.removeMouseMotionListener(controllerPlotarCircunferencia);
		
		meuJPanel.removeMouseListener(controllerPlotarCircunferencia);
		meuJPanel.removeMouseMotionListener(controllerPlotarCircunferencia);
		
		controllerPlotarRetaBresenham = null;
		controllerPlotarRetaDDA = null;
		controllerRetangulo = null;
		controllerPlotarCircunferencia = null;
		
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
//		public void paintT(Graphics g) {
//	        for (int i=0; i<figuras.size(); i++)
//	            figuras.get(i).torneSeVisivel(g);
//	    }
//		
//		@SuppressWarnings("deprecation")
//		public void repintarTela(int x) {
//
//	        try{
//	            Thread.sleep(x);                 //1000 milliseconds is one second.
//	        } catch(InterruptedException ex) {
//	            Thread.currentThread().interrupt();
//	        }
//	        
//
//	        meuJPanel.resize(meuJPanel.getHeight()+1, meuJPanel.getWidth()+1);
//	        meuJPanel.resize(meuJPanel.getHeight()-1, meuJPanel.getWidth()-1);
//		}
//		
	}
}
