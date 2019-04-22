package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

import aplicacion.Arkapoob;

public class pantallaJuego  extends JFrame{
	private painter pin;
	private JPanelB opciones;
	private Container container;
	private myButton pausaBoton;
	private boolean pausa;
	private JLabel score;
	private JLabel vidas;
	private String name;
	private String colorBola;
	private String colorPlata;
	
	public pantallaJuego(String name,String colorBola, String colorPlata){
		super("Arkapoob");
		this.name = name;
		setResizable(false);
		pausa=false;
		prepareElementos();
		prepareAcciones();
		this.colorBola=colorBola;
		this.colorPlata=colorPlata;
		pin.updName(name);
		
	}
	
	public void prepareElementos() {
		ajusteFrame();
		preparePantalla();
		/**
		jugar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				machetin();
			}
		});
		*/
	}
	
	/**
	public void machetin() {
		while (true) {
			
			pin.play();
		}
	}
	*/
	
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
		container = getContentPane();
		opciones = new JPanelB();
		opciones.setLayout(new GridLayout(3,1));
		opciones.setPreferredSize(new Dimension(100, 700));
		opciones.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		container.add(opciones,BorderLayout.EAST);
		
		Icon iconoP= new ImageIcon(getClass().getResource("/resources/pausa.png"));
		pausaBoton = new myButton(iconoP);
		pausaBoton.setTransparent();
		opciones.add(pausaBoton);
		
		pin = new painter(485,665,this);
		container.add(pin, BorderLayout.CENTER);
		pin.setFocusable(true);
		
		score=new JLabel("<html>"+name+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador().getScore())+"</H1></html>",SwingConstants.CENTER);
		vidas=new JLabel("<html>"+name+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador().getLives())+"</H1></html>",SwingConstants.CENTER);
		opciones.add(score);
		opciones.add(vidas);
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
		this.pausa = pausa;
		
		if (pausa) {
			pausaBoton.setIcon(new ImageIcon(getClass().getResource("/resources/pausa.png")));
		}
		else {
			pausaBoton.setIcon(new ImageIcon(getClass().getResource("/resources/continuar.png")));
		}
	}
	
	public void actualiceDatos(){
		score.setText("<html>"+name+" score<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador().getScore())+"</H1></html>");
		vidas.setText("<html>"+name+" lives<br><H1 align=center>"+String.valueOf(pin.getGame().getJugador().getLives())+"</H1></html>");
	}
	
	public String getColorBola(){
		return colorBola;
	}
	
	public String getColorPlataforma(){
		return colorPlata;
	}
}
