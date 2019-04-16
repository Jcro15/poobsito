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
	private pinter pin;
	private Container container;
	
	
	public pantallaJuego(){
		super("sPOOBce Invaders");
		setResizable(false);
		prepareElementos();
		
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
		
		pin = new pinter(550,550);
		container = getContentPane();
		container.add(pin, BorderLayout.CENTER); 
	}
	
}
