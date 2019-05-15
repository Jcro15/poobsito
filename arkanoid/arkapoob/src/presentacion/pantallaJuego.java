package presentacion;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

import aplicacion.*;

public class pantallaJuego  extends JFrame{
	private painter pin;
	private JPanelB opciones;
	private Container container;
	private myButton pausaBoton;
	private boolean pausa;
	private JLabel score;
	private JLabel vidas;
	private JLabel score2;
	private JLabel vidas2;
	private String name;
	private String colorPlata;
	private String name2;
	private String colorPlata2;
	private JMenuBar mB;
	private JMenu menu;
	private JMenuItem salveComo;
    private JMenuItem abra;
	private JFileChooser chooser;
	private int jugadores;
	private boolean usarCpu;
	private String tipo;
	
	
	public pantallaJuego(int jugadores, String name, String colorPlata) throws ArkapoobException{
		super("Arkapoob");
		if(name.equals("")){throw new ArkapoobException(ArkapoobException.NOMBRE_VACIO);}
		this.name = name;
		this.jugadores=jugadores;
		this.usarCpu=false;
		setResizable(false);
		pausa=false;
		prepareElementos();
		prepareAcciones();
		this.colorPlata=colorPlata;
		pin.updName(name,0);
		pin.updColor(colorPlata,0);
	}
	
	public pantallaJuego(int jugadores, String name, String colorPlata,String name2, String colorPlata2,boolean usarCpu)throws ArkapoobException{
		super("Arkapoob");
		if(name.equals("")||name2.equals("")){throw new ArkapoobException(ArkapoobException.NOMBRE_VACIO);}
		this.name = name;
		this.name2 = name2;
		this.jugadores=jugadores;
		this.usarCpu=usarCpu;
		setResizable(false);
		pausa=false;
		prepareElementos();
		prepareAcciones();
		this.colorPlata=colorPlata;
		this.colorPlata2=colorPlata2;
		pin.updName(name,0);
		pin.updColor(colorPlata,0);
		pin.updName(name2,1);
		pin.updColor(colorPlata2,1);
		
	}
	
	public pantallaJuego(int jugadores, String name, String colorPlata,String name2, String colorPlata2,boolean usarCpu,String tipo)throws ArkapoobException{
		super("Arkapoob");
		if(name.equals("")||name2.equals("")){throw new ArkapoobException(ArkapoobException.NOMBRE_VACIO);}
		this.name = name;
		this.name2 = name2;
		this.jugadores=jugadores;
		this.usarCpu=usarCpu;
		this.tipo=tipo;
		setResizable(false);
		pausa=false;
		prepareElementos();
		prepareAcciones();
		this.colorPlata=colorPlata;
		this.colorPlata2=colorPlata2;
		pin.updName(name,0);
		pin.updColor(colorPlata,0);
		pin.updName(name2,1);
		pin.updColor(colorPlata2,1);
		
	}
	
	
	public void prepareElementos() {
		ajusteFrame();
		preparePantalla();
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
	
	private void preparePantalla() {
		chooser=new JFileChooser();
		mB=new JMenuBar();
		setJMenuBar(mB);
		menu=new JMenu("Archivo");
		mB.add(menu);
		salveComo=new JMenuItem("Salve como");
		abra=new JMenuItem("Abrir");
		menu.add(abra);
		menu.add(salveComo);
		setIconImage(new ImageIcon(getClass().getResource("/resources/icono.png")).getImage());
		container = getContentPane();
		opciones = new JPanelB();
		opciones.setLayout(new GridLayout(5,1));
		opciones.setPreferredSize(new Dimension(100, 700));
		opciones.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		container.add(opciones,BorderLayout.EAST);
		
		Icon iconoP= new ImageIcon(getClass().getResource("/resources/pausa.png"));
		pausaBoton = new myButton(iconoP);
		pausaBoton.setTransparent();
		opciones.add(pausaBoton);
		
		pin = new painter(jugadores,usarCpu,485,665,this);
		
		container.add(pin, BorderLayout.CENTER);
		pin.setFocusable(true);
		if(jugadores==1){
			score=new JLabel("<html>"+name+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getScore())+"</H1></html>",SwingConstants.CENTER);
			vidas=new JLabel("<html>"+name+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getLives())+"</H1></html>",SwingConstants.CENTER);
			opciones.add(score);
			opciones.add(vidas);
			opciones.add(new JLabel());
			opciones.add(new JLabel());
		}
		else{
			score=new JLabel("<html>"+name+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getScore())+"</H1></html>",SwingConstants.CENTER);
			vidas=new JLabel("<html>"+name+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getLives())+"</H1></html>",SwingConstants.CENTER);
			score2=new JLabel("<html>"+name2+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(1).getScore())+"</H1></html>",SwingConstants.CENTER);
			vidas2=new JLabel("<html>"+name2+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(1).getLives())+"</H1></html>",SwingConstants.CENTER);
			opciones.add(score);
			opciones.add(vidas);
			opciones.add(score2);
			opciones.add(vidas2);
		}
		
		
		//pin.requestFocusInWindow();
	}
	
	public void prepareAcciones(){
		prepareAccionesVentana();
		prepareAccionesPantalla();
	}
	
	public void prepareAccionesVentana(){
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				cerrar();
			}
		});
	}
	
	public void prepareAccionesPantalla(){
		pausaBoton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (pausa) {
					pausaBoton.setIcon(new ImageIcon(getClass().getResource("/resources/pausa.png")));
				}
				else {
					pausaBoton.setIcon(new ImageIcon(getClass().getResource("/resources/continuar.png")));
				}
				play();
			}
		});
		
		salveComo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcionSalveComo();
			}
			});
		
		abra.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcionAbra();
			}
			});
	}
	
	private void opcionSalveComo(){
		if (!pausa){ accionPausa();}
		chooser.setFileFilter(new FileNameExtensionFilter("archivos .dat", "dat"));
		int opc =chooser.showSaveDialog(this);
		try{
			if (opc==JFileChooser.APPROVE_OPTION){
				File file =chooser.getSelectedFile();
				pin.salvar(file);
			}
		}
		catch (ArkapoobException e){
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
	
	private void opcionAbra(){
		if (!pausa){ accionPausa();}
		chooser.setFileFilter(new FileNameExtensionFilter("archivos .dat", "dat"));
		int opc =chooser.showOpenDialog(this);
		try{
			if (opc==JFileChooser.APPROVE_OPTION){
				File file =chooser.getSelectedFile();
				pin.abrir(file);
				pin.jugar();
				accionPausa();
				actualiceDatos();
			}
		}
		catch (ArkapoobException e){
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		
	}
	
	public void play() {
		if (pausa) pausa = false;
		else pausa = true;
		pin.play();
	}
	
	public void cerrar() {
		pin.cierre();
		dispose();
	}
	
	
	
	public void actualiceBotonPausa(boolean pausa) {
		
		
		if (pausa) {
			pausaBoton.setIcon(new ImageIcon(getClass().getResource("/resources/pausa.png")));
		}
		else {
			pausaBoton.setIcon(new ImageIcon(getClass().getResource("/resources/continuar.png")));
		}
	}
	
	public void actualiceDatos(){
		if(jugadores==1){
			score.setText("<html>"+name+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getScore())+"</H1></html>");
			vidas.setText("<html>"+name+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getLives())+"</H1></html>");
		}
		else{
			score.setText("<html>"+name+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getScore())+"</H1></html>");
			vidas.setText("<html>"+name+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(0).getLives())+"</H1></html>");
			score2.setText("<html>"+name2+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(1).getScore())+"</H1></html>");
			vidas2.setText("<html>"+name2+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador(1).getLives())+"</H1></html>");
			
		}
	}
	
	public String getColorPlataforma(){
		return colorPlata;
	}
	public String getColorPlataforma2(){
		return colorPlata2;
	}
	
	public void accionPausa(){
		play();
		
	}
	public String getName(){
		return name;
	}
	public void setGame(File file) throws ArkapoobException {
		pin.abrir(file);
	}
	public painter getPainter(){
		return pin;
	}
	
	public String getTipo(){
		return tipo;
	}
	
}
