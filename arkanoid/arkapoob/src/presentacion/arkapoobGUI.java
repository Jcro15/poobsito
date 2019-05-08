package presentacion;


import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;
import persistencia.*;
import aplicacion.*;

public class arkapoobGUI extends JFrame{
	private Container contenedor;
	private JPanelB panelPantalla;
	private JPanel panelLogo;
	private JPanel panelBotones;
	private JLabel logo;
	private myButton jugarBoton;
	private myButton abrirBoton;
	private JFileChooser chooser;
	private static transient ArkapoobDAO arkaDAO;
	
	public arkapoobGUI(){
		super("Arkapoob");
		setResizable(false);
		contenedor = getContentPane();
		
		prepareElementos();
		prepareAcciones();
	}
	
	public void prepareElementos() {
		ajusteFrame();
		prepareElementosPantalla();
	}
	
	public void ajusteFrame(){
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int height=700;
		int width=600;
		setSize(width,height);
		int centerX = size.width/2;
		int centerY = size.height/2;
		int halfWidth = width/2;
		int halfHeight = height-340;
		setLocation(centerX - halfWidth, centerY - halfHeight);
	}
	
	public void prepareElementosPantalla(){
		chooser=new JFileChooser();
		setIconImage(new ImageIcon(getClass().getResource("/resources/icono.png")).getImage());
		
		panelPantalla = new JPanelB();
		panelPantalla.setLayout(new GridLayout(2,1));
		panelPantalla.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		
		panelLogo = new JPanel();
		panelLogo.setLayout(new GridBagLayout());
		panelPantalla.add(panelLogo);
		panelLogo.setOpaque(false);
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(3,3,0,5));
		panelPantalla.add(panelBotones);
		panelBotones.setOpaque(false);
		
		preparePanelBotones();
		preparePanelLogo();
		contenedor.add(panelPantalla);
	}
	
	public void prepareAcciones(){
		prepareAccionesVentana();
		prepareAccionesPantalla();
	}
	
	public void prepareAccionesVentana(){
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
		addWindowListener (new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				salga();
			}
		});
	}
	
	public void prepareAccionesPantalla(){
		jugarBoton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				juega();
			}
		});
		 
		abrirBoton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abra();
			}
		});
	}
	
	public void preparePanelBotones(){
		
		panelBotones.add(new JLabel()); 
		Icon icono = new ImageIcon(getClass().getResource("/resources/jugar.png"));
		jugarBoton = new myButton(icono);
		jugarBoton.setTransparent();
		panelBotones.add(jugarBoton);
		panelBotones.add(new JLabel()); 
		
		panelBotones.add(new JLabel());
		Icon icono1 = new ImageIcon(getClass().getResource("/resources/abrir.png"));
		abrirBoton = new myButton(icono1);
		abrirBoton.setTransparent();
		panelBotones.add(abrirBoton);
		panelBotones.add(new JLabel());
		
		panelBotones.add(new JLabel());
		panelBotones.add(new JLabel());
		panelBotones.add(new JLabel());
	}
	
	private void preparePanelLogo() {
		logo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo.png")));
		panelLogo.add(logo);		
	}
	
	public void abra(){
		chooser.setFileFilter(new FileNameExtensionFilter("archivos .dat", "dat"));
		int opc =chooser.showOpenDialog(this);
		arkaDAO=new ArkapoobDAO();
		try{
			if (opc==JFileChooser.APPROVE_OPTION){
				File file =chooser.getSelectedFile();
				Arkapoob game = arkaDAO.abrir(file);
				pantallaJuego pj= new pantallaJuego(game.getNJugadores(),game.getJugador(0).getName(),game.getJugador(0).getPlatform().getColorString());
				
				
				pj.setGame(file);
				
				pj.getPainter().jugar();
				pj.accionPausa();
				pj.actualiceDatos();
				
				pj.setVisible(true);
				
			}
		}
		catch (ArkapoobException e){
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
	
	
	public void opcionEnConstruccion(String operacion){
		JOptionPane.showMessageDialog(this,operacion ,"Operacion en construccion",JOptionPane.INFORMATION_MESSAGE  );
	}
	
	public void salga(){
		int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option==0){
			System.exit(0);
		}
	}
	public void juega(){
		seleccionModoGUI modoGui = new seleccionModoGUI();
		modoGui.setVisible(true);
	}
	
	public static void main(String[] args) {
		arkapoobGUI a = new arkapoobGUI();
		a.setVisible(true);
	}
}