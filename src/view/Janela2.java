package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerCircunferencia;
import controller.ControllerPlotar;
import controller.ControllerRetaBresenham;
//import controller.ControllerRetaDDA;
import model.AbstractFigura;

public class Janela2 extends JFrame {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	
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
	public Janela2() {
		
		super();
		Container cntForm;
		
		cntForm = this.getContentPane();
		cntForm.setLayout (new BorderLayout());
		
		JPanel     pnlBotoes = new JPanel();
        GridBagConstraints flwBotoes = new GridBagConstraints(); 
        
        pnlBotoes.setLayout (new GridBagLayout());
        
        flwBotoes.fill = GridBagConstraints.HORIZONTAL;
        flwBotoes.gridy = 0;
        pnlBotoes.add(btnRetaBresenham,flwBotoes);
        pnlBotoes.add(btnRetaDDA,flwBotoes);
        pnlBotoes.add(btnCircunferencia,flwBotoes);

        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (meuJPanel,  BorderLayout.CENTER);

		
		btnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerPlotar controllerPlotarCirc = new ControllerCircunferencia(meuJPanel,figuras);
				cntForm.addMouseListener(controllerPlotarCirc);
				cntForm.addMouseMotionListener(controllerPlotarCirc);
			}
		});
		
        
		controllerPlotarRetaBresenham = new ControllerRetaBresenham(meuJPanel,figuras);
        btnRetaBresenham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerPlotarRetaBresenham.repintarTela();
				cntForm.removeMouseListener(controllerPlotarRetaDDA);
				cntForm.removeMouseMotionListener(controllerPlotarRetaDDA);
				controllerPlotarRetaBresenham.setNomeClass("bresenham");
				cntForm.addMouseListener(controllerPlotarRetaBresenham);
				cntForm.addMouseMotionListener(controllerPlotarRetaBresenham);
				controllerPlotarRetaBresenham.repintarTela();
			}
		});
		
		btnRetaDDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntForm.removeMouseListener(controllerPlotarRetaBresenham);
				cntForm.removeMouseMotionListener(controllerPlotarRetaBresenham);
				controllerPlotarRetaDDA = new ControllerRetaBresenham(meuJPanel,figuras);
				controllerPlotarRetaDDA.setNomeClass("dda");
				cntForm.addMouseListener(controllerPlotarRetaDDA);
				cntForm.addMouseMotionListener(controllerPlotarRetaDDA);
//				meuJPanel.repintarTela();
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
