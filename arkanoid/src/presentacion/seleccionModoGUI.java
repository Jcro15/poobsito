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
	private JButton single;
	private JButton  coop;
	private JButton  jVsCpu;
	private JButton  volverBoton;
	private JButton  jugarBoton;
	private JButton  cancelarBoton;
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
		panelPantalla.setBackground("fondo.png");
		contenedor.add(panelPantalla);
		panelLogo = new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon("logo.png"));
		panelLogo.add(logo);
		panelPantalla.add(panelLogo);
		panelLogo.setOpaque(false);
		panelBotones = new JPanel(new GridLayout(2,3));
		panelBotones.setOpaque(false);
		Icon icono1j = new ImageIcon("1J.png");
		single = new JButton(icono1j);
		setTransparent(single);
		Icon icono2j = new ImageIcon("2J.png");
		coop = new JButton(icono2j);
		setTransparent(coop);
		Icon iconoJVC = new ImageIcon("jVC.png");
		jVsCpu = new JButton(iconoJVC);
		setTransparent(jVsCpu);
		Icon iconot = new ImageIcon("blan.png");
		JButton t = new JButton(iconot);
		setTransparent(t);
		Icon iconoCancelar = new ImageIcon("volver.png");
		cancelarBoton = new JButton(iconoCancelar);
		setTransparent(cancelarBoton);
		
		
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
		configPanel.setBackground("fondo.png");
		cards.add(configPanel,"Configuracion");
		JPanel panelCButton = new JPanel();
		panelCButton.setOpaque(false);
		
		JPanel panelConfigLogo= new JPanel(new GridBagLayout());
		logo = new JLabel(new ImageIcon("logo.png"));
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
		
		Icon iconoCancelar = new ImageIcon("volver.png");
		volverBoton = new JButton(iconoCancelar);
		setTransparent(volverBoton);
		
		Icon iconoJ = new ImageIcon("jugar1.png");
		jugarBoton = new JButton(iconoJ);
		setTransparent(jugarBoton);
		
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
	public void juegue(){}
	public void setTransparent(JButton boton){
		
		boton.setOpaque(false);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
		boton.setFocusable(false);
	}
	
	private void principal() {
		setTitle("Configuracion");
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards,"Principal");
		ajusteFrame();
		
	}
}