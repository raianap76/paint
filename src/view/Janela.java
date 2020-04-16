package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.ControllerPlotar;
import controller.ControllerRetaBresenham;

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
		
		JButton retaBresenham = new JButton("reta bresenham");	
		menuBar.add(retaBresenham);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		retaBresenham.addActionListener(new ControllerRetaBresenham(meuJPanel,cntForm));
		
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
