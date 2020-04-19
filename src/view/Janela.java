package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerPlotar;
import controller.ControllerRetaBresenham;
//import controller.ControllerRetaDDA;
import model.AbstractFigura;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	
	private MeuJPanel meuJPanel = new MeuJPanel();
	
	JButton btnRetaBresenham = new JButton("reta bresenham");
	JButton btnRetaDDA = new JButton("reta dda");
	private Vector<AbstractFigura> figuras = new Vector<AbstractFigura>();
	
	/**
	 * Create the frame.
	 */
	public Janela() {
		
		super();
		
		
		Container cntForm = this.getContentPane();
		cntForm.setLayout (new BorderLayout());
		
		JPanel     pnlBotoes = new JPanel();
        GridBagConstraints flwBotoes = new GridBagConstraints(); 
        
        pnlBotoes.setLayout (new GridBagLayout());
        
        flwBotoes.fill = GridBagConstraints.HORIZONTAL;
        flwBotoes.gridy = 0;
        pnlBotoes.add(btnRetaBresenham,flwBotoes);
        pnlBotoes.add(btnRetaDDA,flwBotoes);

//        ControllerPlotar merda = new ControllerRetaBresenham(meuJPanel,figuras,"RetaBresenham");
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (meuJPanel,  BorderLayout.CENTER);
//        cntForm.addMouseListener(merda);
        
        
        ControllerPlotar controllerPlotarReta = new ControllerRetaBresenham(meuJPanel,figuras);
        
        btnRetaBresenham.addActionListener(controllerPlotarReta);
        btnRetaDDA.addActionListener(controllerPlotarReta);
        //        meuJPanel.
        
		
//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
//		
		
//		menuBar.add(btnRetaBresenham);
//		
//		JButton btnRetaDDA = new JButton("reta dda");
//		menuBar.add(btnRetaDDA);
//		
//		JButton btnCircunferencia = new JButton("circunferencia");
//		btnCircunferencia.setMnemonic('o');
//		menuBar.add(btnCircunferencia);
//		
//		
//		JPanel jpanelBotoes = new JPanel();
//		jpanelBotoes.add(menuBar);
//		
//		cntForm.add(menuBar, BorderLayout.NORTH);
//		cntForm.add (meuJPanel, BorderLayout.CENTER);
		
//		ControllerPlotar controllerPlotar = new ControllerPlotar(meuJPanel);
//		
//		btnRetaBresenham.addActionListener(controllerPlotar);
//		btnRetaDDA.addActionListener(controllerPlotar);
		
		
//		ControllerRetaDDA controllerRetaDDA = new ControllerRetaDDA(meuJPanel);
//		ControllerCircunferencia controllerCircunferencia = new ControllerCircunferencia(meuJPanel);
		
		
		
//		btnCircunferencia.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				cntForm.removeMouseListener(controllerRetaResenham);
//				cntForm.removeMouseListener(controllerRetaDDA);
//				cntForm.addMouseListener(controllerCircunferencia);
//			}
//		});
		
//		btnRetaBresenham.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				cntForm.removeMouseListener(controllerCircunferencia);
////				cntForm.removeMouseListener(controllerRetaDDA);
//				cntForm.addMouseListener(controllerRetaResenham);
//			}
//		});
//		
//		btnRetaDDA.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cntForm.removeMouseListener(controllerCircunferencia);
//				cntForm.removeMouseListener(controllerRetaResenham);
//				cntForm.addMouseListener(controllerRetaDDA);
//			}
//		});
//		
		
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
		public void paint(Graphics g) {
	        for (int i=0; i<figuras.size(); i++)
	            figuras.get(i).torneSeVisivel(g);
	    }
		
		public void repintarTela(int x) {

	        try{
	            Thread.sleep(x);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
	        

	        meuJPanel.resize(meuJPanel.getHeight()+1, meuJPanel.getWidth()+1);
	        meuJPanel.resize(meuJPanel.getHeight()-1, meuJPanel.getWidth()-1);
		}
		
		public void repintarTela() {

	        try{
	            Thread.sleep(10);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
	        

	        meuJPanel.resize(meuJPanel.getHeight()+1, meuJPanel.getWidth()+1);
	        meuJPanel.resize(meuJPanel.getHeight()-1, meuJPanel.getWidth()-1);
		}
	}
	
}
