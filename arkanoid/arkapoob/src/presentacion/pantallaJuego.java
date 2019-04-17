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
	private Container container;
	private JButton jugar;
	private Arkapoob asd;
	
	
	public pantallaJuego(){
		super("sPOOBce Invaders");
		setResizable(false);
		prepareElementos();
		
	}
	public void prepareElementos() {
		ajusteFrame();
		preparePantalla();
		jugar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				machetin();
			}
		});
		
	}
	public void machetin() {
		while (true) {
			
			pin.play();
		}
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
		
		pin = new painter(580,641);
		container = getContentPane();
		container.add(pin, BorderLayout.CENTER);
		jugar=new JButton("jugar");
		container.add(jugar,BorderLayout.NORTH);
		
	}
}
