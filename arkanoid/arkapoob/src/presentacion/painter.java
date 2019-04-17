package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.border.*;
import java.io.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Timer;
import javax.swing.KeyStroke;

import aplicacion.*;

public class painter extends JPanel {
	
	private Arkapoob game;
	private Graphics2D g2;
	private Ellipse2D.Double figura;
	private pantallaJuego pantallaJ;
	private boolean play;
	private Timer playerTimer;
	private boolean p1Izq, p1Der = false;
	
	
	public painter(int w, int h){
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		game=new Arkapoob(w,h);
		prepareAcciones();
		
		playerTimer = new Timer(20,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movePlat();

				game.moverBola();
				paint(getGraphics());
				
			}
		});
		playerTimer.start();
		
		
	}
	private void movePlat() {

		if (p1Der) {
			moverPlatDer();
		}
		if (p1Izq) {
			moverPlatIzq();
		}
	}
	
	private void prepareAcciones() {
		setFocusable(true);

		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right1down");
		getActionMap().put("right1down", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p1Der=true;			
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right1up");
		getActionMap().put("right1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				p1Der = false;
			}
		});


		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left1down");
		getActionMap().put("left1down", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p1Izq = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "left1up");
		getActionMap().put("left1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				p1Izq = false;
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.getKeyCode() == KeyEvent.VK_P) {
					play();
					pantallaJ.actualiceBotonPausa(play);
				}
			}
		});
	}
	
	public void moverPlatDer(){
		System.out.println("bbb");
		game.moverPlataformaDerecha();
		
	}
	
	public void moverPlatIzq(){
		game.moverPlataformaIzquierda();
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g2 = (Graphics2D) g ;
		g2.setColor(Color.WHITE);
		figura = game.getBola().getShape();
		g2.fill(figura);
		Jugador j = game.getJugador();
		Plataforma p = j.getPlatform();
		Rectangle pla = p.getShape();
		g2.fill(pla);
		ArrayList<Bloque> s= game.getBloques();
		for(Bloque i:s) {
			Rectangle  r= i.getShape();
			g2.setColor(i.getColor());
			g2.fill(r);
		}
		
	}
	
	
	public void play() {
		
		if(play) {
			play = false;
			playerTimer.stop();
		}
		else {
			play = true;
			playerTimer.start();
		}
		
	}
	
	public void cierre() {
		playerTimer.stop();
	}
	private void detengase() {
		
		pantallaJ.cerrar();
		
		
	}
	
	
	
	
}
