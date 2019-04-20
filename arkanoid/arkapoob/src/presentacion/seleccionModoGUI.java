package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

public class seleccionModoGUI extends JFrame{
	
	private JPanelB panelPantalla;
	private JPanel	panelBotones, panelLogo;
	private myButton single;
	private myButton  coop;
	private myButton  jVsCpu;
	private myButton  volverBoton;
	private myButton  jugarBoton;
	private myButton  cancelarBoton;
	private JLabel logo;
	private Container contenedor;
	private JComboBox<String> selecColorBall;
	private JComboBox<String> selecColorBar;
	private JPanel cards;
	private static final String []colores = { "Verde", "Azul","Amarillo","Rojo"};
	
	public seleccionModoGUI(){
		super("Seleccion Modo");
		contenedor = getContentPane();
		setResizable(false);
		prepareElementos();
		prepareAcciones();
	}
	
	public void prepareElementos(){
		ajusteFrame();
		prepareElementosPantalla();
		prepareElementosConfig();
	}
	public void ajusteFrame(){
		
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int height=250;
		int width=700;
		setSize(width,height);
		int centerX = size.width/2;
		int centerY = size.height/2;
		int halfWidth = width/2;
		int halfHeight = height-125;
		setLocation(centerX - halfWidth, centerY - halfHeight);
	}
	
	public void ajusteFrameConfig(){
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
		panelPantalla = new JPanelB();
		panelPantalla.setLayout(new GridLayout(2,1));
		panelPantalla.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		contenedor.add(panelPantalla);
		panelLogo = new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo.png")));
		panelLogo.add(logo);
		panelPantalla.add(panelLogo);
		panelLogo.setOpaque(false);
		panelBotones = new JPanel(new GridLayout(2,3));
		panelBotones.setOpaque(false);
		Icon icono1j = new ImageIcon(getClass().getResource("/resources/1J.png"));
		single = new myButton(icono1j);
		single.setTransparent();
		Icon icono2j = new ImageIcon(getClass().getResource("/resources/2J.png"));
		coop = new myButton(icono2j);
		coop.setTransparent();
		Icon iconoJVC = new ImageIcon(getClass().getResource("/resources/jVC.png"));
		jVsCpu = new myButton(iconoJVC);
		jVsCpu.setTransparent();
		Icon iconot = new ImageIcon(getClass().getResource("/resources/blan.png"));
		myButton t = new myButton(iconot);
		t.setTransparent();
		Icon iconoCancelar = new ImageIcon(getClass().getResource("/resources/volver.png"));
		cancelarBoton = new myButton(iconoCancelar);
		cancelarBoton.setTransparent();
		
		
		panelBotones.add(single);
		panelBotones.add(coop);
		panelBotones.add(jVsCpu);
		panelBotones.add(t);
		panelBotones.add(cancelarBoton);
		
		
		panelPantalla.add(panelBotones);
		
		cards = new JPanel(new CardLayout());
		cards.add(panelPantalla, "Principal");
		contenedor.add(cards);
		
		
	}
	public void prepareElementosConfig(){
		JPanelB configPanel = new JPanelB();
		configPanel.setLayout(new GridLayout(3,1));
		configPanel.setBackground(new ImageIcon(getClass().getResource("/resources/fondo.png")));
		cards.add(configPanel,"Configuracion");
		JPanel panelCButton = new JPanel();
		panelCButton.setOpaque(false);
		
		JPanel panelConfigLogo= new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon(getClass().getResource("/resources/logo.png")));
		panelConfigLogo.add(logo);
		panelConfigLogo.setOpaque(false);
		
		JPanel combo = new JPanel();
		combo.setLayout(null);
		combo.setOpaque(false);
		
		JLabel colorBola = new JLabel("Color bola");
		colorBola.setForeground(Color.WHITE);
		colorBola.setBounds(27, 85, 78, 14);
		combo.add(colorBola);
		selecColorBall = new JComboBox<>(colores);
		selecColorBall.setBounds(135, 82, 121, 17);
		combo.add(selecColorBall);
		
		JLabel colorBarra = new JLabel("Color barra");
		colorBarra.setForeground(Color.WHITE);
		colorBarra.setBounds(27, 135, 78, 14);
		combo.add(colorBarra);
		selecColorBar = new JComboBox<>(colores);
		selecColorBar.setBounds(135, 132, 242, 17);
		combo.add(selecColorBar);
		
		Icon iconoCancelar = new ImageIcon(getClass().getResource("/resources/volver.png"));
		volverBoton = new myButton(iconoCancelar);
		volverBoton.setTransparent();
		
		Icon iconoJ = new ImageIcon(getClass().getResource("/resources/jugar1.png"));
		jugarBoton = new myButton(iconoJ);
		jugarBoton.setTransparent();
		
		panelCButton.add(jugarBoton);
		panelCButton.add(volverBoton);
		
		
		configPanel.add(panelConfigLogo);
		configPanel.add(combo);
		configPanel.add(panelCButton);
		configPanel.setOpaque(false);
		prepareAccionesConfig();
		
		
	}
	public void prepareAcciones(){
		
		single.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirConfig();
			}
		});
		
		cancelarBoton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		coop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirConfig();
			}
		});
		
		jVsCpu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirConfig();
			}
		});
		
		
	}
	private void prepareAccionesConfig() {
		volverBoton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				principal();
				
			}
		});
		
		jugarBoton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				juegue();
				
			}
		});
	}
	
	public void abrirConfig(){
		setTitle("Configuracion");
		ajusteFrameConfig();
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards,"Configuracion");
	}
	public void juegue(){
		dispose();
		pantallaJuego j = null;
		j=new pantallaJuego();
		j.setVisible(true);
		
		
		
	}
	
	
	private void principal() {
		setTitle("Configuracion");
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards,"Principal");
		ajusteFrame();
		
	}
}