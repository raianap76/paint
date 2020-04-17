package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.ControllerCircunferencia;
import controller.ControllerRetaBresenham;
import controller.ControllerRetaDDA;
import javax.swing.JLabel;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	
	private MeuJPanel meuJPanel = new MeuJPanel();
	/**
	 * Create the frame.
	 */
	public Janela() {
		
		super();
		
		Container cntForm = this.getContentPane();
		cntForm.setLayout (new BorderLayout());
		cntForm.add (meuJPanel, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnRetaBresenham = new JButton("reta bresenham");	
		menuBar.add(btnRetaBresenham);
		
		JButton btnRetaDDA = new JButton("reta dda");
		menuBar.add(btnRetaDDA);
		
		JButton btnCircunferencia = new JButton("circunferencia");
		btnCircunferencia.setMnemonic('o');
		menuBar.add(btnCircunferencia);
		
//		ControllerPlotar controllerPlotar = new ControllerPlotar(meuJPanel);
//		
//		btnRetaBresenham.addActionListener(controllerPlotar);
//		btnRetaDDA.addActionListener(controllerPlotar);
		
		
		ControllerRetaBresenham controllerRetaResenham = new ControllerRetaBresenham(meuJPanel);
		ControllerRetaDDA controllerRetaDDA = new ControllerRetaDDA(meuJPanel);
		ControllerCircunferencia controllerCircunferencia = new ControllerCircunferencia(meuJPanel);
		
		
		
		btnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cntForm.removeMouseListener(controllerRetaResenham);
				cntForm.removeMouseListener(controllerRetaDDA);
				cntForm.addMouseListener(controllerCircunferencia);
			}
		});
		
		btnRetaBresenham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntForm.removeMouseListener(controllerCircunferencia);
				cntForm.removeMouseListener(controllerRetaDDA);
				cntForm.addMouseListener(controllerRetaResenham);
			}
		});
		
		btnRetaDDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntForm.removeMouseListener(controllerCircunferencia);
				cntForm.removeMouseListener(controllerRetaResenham);
				cntForm.addMouseListener(controllerRetaDDA);
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setSize (1024,720);
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
	}
	
}
