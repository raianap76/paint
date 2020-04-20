package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ControllerPlotar;
import model.AbstractFigura;
import model.Circunferencia;
import model.Ponto;
import model.RetaBresenham;
import model.RetaDDA;
import model.Retangulo;


public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MeuJPanel meuJPanel = new MeuJPanel();
	private Vector<AbstractFigura> figuras = new Vector<AbstractFigura>();
	
	private final JButton btnPonto = new JButton("ponto");
	private final JButton btnRetaBresenham = new JButton("reta bresenham");
	private final JButton btnRetaDDA = new JButton("reta dda");
	private final JButton btnCircunferencia = new JButton("circunferencia");
	private final JButton btnRetangulo = new JButton("retangulo");
	private final JButton btnSalvar = new JButton("salvar");
	private final JButton btnAbrir = new JButton("abrir");
	
	ControllerPlotar controllerPlotarRetaBresenham;
	ControllerPlotar controllerPlotarRetaDDA;
	ControllerPlotar controllerRetangulo;
	ControllerPlotar controllerPlotarCircunferencia;
	ControllerPlotar ControllerPonto;
	
	
	


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
		menuBar.add(btnPonto);
		menuBar.add(btnRetaBresenham);
		menuBar.add(btnRetaDDA);
		menuBar.add(btnCircunferencia);
		menuBar.add(btnRetangulo);
		menuBar.add(btnAbrir);
		menuBar.add(btnSalvar);	
		
		btnAbrir.addActionListener(new Abrir());
		btnSalvar.addActionListener(new Salvar());
		
		
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAllListener();
				ControllerPonto = new ControllerPlotar(meuJPanel,figuras);
				ControllerPonto.setNomeClass("ponto");
				meuJPanel.addMouseMotionListener(ControllerPonto);
				meuJPanel.addMouseListener(ControllerPonto);

			}
		});
		
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
		
		this.addWindowListener(new FecharTela());
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
		private static final long serialVersionUID = 1L;
		public MeuJPanel() {
			super();	
		}
		public void desenhar(int x, int y) {
			
			meuJPanel.getGraphics().setColor(Color.BLACK);
			meuJPanel.getGraphics().drawLine(x, y, x, y);
		}
		

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

	
	private class FecharTela extends WindowAdapter {
        public void windowClosing (WindowEvent e) {
            
            String Texto=null; 
            String SaidaSalva=("Salvando"); 
            String SaidaSemSalvar=("Saindo sem salvar"); 
            Texto = JOptionPane.showInputDialog("Deseja salvar? (sim/nao)");
            if(Texto.equals("Sim")==true || Texto.equals("sim")==true){
                JOptionPane.showMessageDialog(null, SaidaSalva);
                String string1 = new String(SaidaSalva);
                System.out.println(string1);

                JFileChooser j= new JFileChooser();

                int returnVal = j.showSaveDialog(Janela.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        String arquivo = j.getSelectedFile().getAbsolutePath();
                    if(!arquivo.endsWith(".paint"))
                                    arquivo+=".paint";
                    FileWriter fw = new FileWriter(arquivo);
                        for(int k = 0; k<figuras.size(); k++){
                            fw.write(figuras.elementAt(k).toString());
                            fw.write("\n");
                        }
                        fw.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.exit(0);
            }
            else{
                    JOptionPane.showMessageDialog(null, SaidaSemSalvar);
                    String string1 = new String(SaidaSemSalvar);
                    System.out.println(string1);
                    System.exit(0);		
            }
        }
    }
	
	
	private class Salvar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
                JFileChooser j= new JFileChooser();
                j.setFileFilter(new FileNameExtensionFilter("Paint Files", "paint", ".paint"));    
    	        j.setAcceptAllFileFilterUsed(false);   
                
               
                int returnVal = j.showSaveDialog(Janela.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    String arquivo = j.getSelectedFile().getAbsolutePath();
                    if(!arquivo.endsWith(".paint"))
                                    arquivo+=".paint";
                    FileWriter fw = new FileWriter(arquivo);
                    for(int k = 0; k<figuras.size(); k++){
                        fw.write(figuras.elementAt(k).toString());
                        fw.write("\n");
                    }
                    fw.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
               
        }
    }
	
	
	private class Abrir implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String p = "p";
            String b = "b";
            String c = "c";
            String d = "d";
            String r = "r";
 
            boolean aberto = false;
            JFileChooser j= new JFileChooser();
            j.setFileFilter(new FileNameExtensionFilter("Paint Files", "paint", ".paint"));    
    	        j.setAcceptAllFileFilterUsed(false);   
            int returnVal = j.showOpenDialog(Janela.this);
            String arquivo = j.getSelectedFile().getAbsolutePath();
            if(!arquivo.endsWith(".paint"))
                                    arquivo+=".paint";
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    Scanner scanner = new Scanner(new FileReader(arquivo)).useDelimiter("\\s*:\\s*|\\s*\n\\s*");
                    figuras.clear();
                    repintarTela();
                    while (scanner.hasNext()) {
                        String tipo = scanner.next();
                        System.out.println("inicio");
                        System.out.println(tipo);
                        if(p.equals(tipo)){
                            System.out.println("entrou ponto");
                            figuras.add (new Ponto (Integer.parseInt(scanner.next()), 
                                                    Integer.parseInt(scanner.next())));
                            figuras.get(figuras.size()-1).torneSeVisivel(meuJPanel.getGraphics());
                            scanner.next();
                        }
                        if(b.equals(tipo)){
                            System.out.println("entrou bresenham");
                            Ponto p1 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            Ponto p2 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            figuras.add (new RetaBresenham(p1,p2));
                            figuras.get(figuras.size()-1).torneSeVisivel(meuJPanel.getGraphics());
                           
                        }
                        if(d.equals(tipo)){
                            System.out.println("entrou dda");
                            Ponto p1 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            Ponto p2 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            figuras.add (new RetaDDA(p1,p2));
                            figuras.get(figuras.size()-1).torneSeVisivel(meuJPanel.getGraphics());
                           
                        }
                        if(c.equals(tipo)){
                            System.out.println("entrou circunferencia");
                            Ponto p1 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            int raio = Integer.parseInt(scanner.next());
                            figuras.add (new Circunferencia(p1,raio));
                            figuras.get(figuras.size()-1).torneSeVisivel(meuJPanel.getGraphics());
                           
                        }
                        if(r.equals(tipo)){
                            System.out.println("entrou retangulo");
                            Ponto p1 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            Ponto p2 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            Ponto p3 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            Ponto p4 = new Ponto(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
                            figuras.add (new Retangulo(p1,p2,p3,p4));
                            figuras.get(figuras.size()-1).torneSeVisivel(meuJPanel.getGraphics());
                           
                        }
                        System.out.println("fim");
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
               }
            }
        }
	}
}
