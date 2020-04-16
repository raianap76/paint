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

import controller.ControllerPlotar;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	
	private MeuJPanel meuJPanel = new MeuJPanel();
	private ControllerPlotar controllerPlotar;

	/**
	 * Create the frame.
	 */
	public Janela() {
		
		super();
		
		
		Container cntForm = this.getContentPane();
		cntForm.setLayout (new BorderLayout());
		
		controllerPlotar = new ControllerPlotar();
		cntForm.addMouseListener(controllerPlotar);
		cntForm.add (meuJPanel, BorderLayout.CENTER);
		controllerPlotar.setJPanel(meuJPanel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton retaBresenham = new JButton("reta bresenham");
		menuBar.add(retaBresenham);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		retaBresenham.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controllerPlotar.setFigure(0);
				
			}
			
		});
		
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
		
		public void desenhar(int x, int y,int x2,int y2) {
			
			meuJPanel.getGraphics().setColor(Color.BLACK);
			meuJPanel.getGraphics().drawLine(x, y, x2, y2);
		}
	}
	
}
