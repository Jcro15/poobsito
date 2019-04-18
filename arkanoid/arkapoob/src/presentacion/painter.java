package presentacion;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import aplicacion.*;

public class painter extends JPanelB {
	
	private Arkapoob game;
	private Graphics2D g2;
	private Ellipse2D.Double figura;
	private pantallaJuego pantallaJ;
	private boolean play;
	private Timer playerTimer;
	private boolean p1Left, p1Right = false;
	
	
	public painter(int w, int h){
		
		setBackground("fondo1.png");
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		play = true;
		game=new Arkapoob(w,h);
		setFocusable(true);
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
		//System.out.println("ddd");
		if (p1Right) {
			moverPlatDer();
		}
		if (p1Left) {
			moverPlatIzq();
		}
	}
	
	private void prepareAcciones() {
		
		setFocusable(true);
		
        //requestFocusInWindow();
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right1down");
		getActionMap().put("right1down", new AbstractAction() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				p1Right = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right1up");
		getActionMap().put("right1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				
				p1Right = false;
			}
		});


		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left1down");
		getActionMap().put("left1down", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p1Left = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "left1up");
		getActionMap().put("left1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				p1Left = false;
			}
		});

		/**
		addKeyListener(new KeyListener() {
			
            public void keyTyped(KeyEvent e) {}

                    
            public void keyReleased(KeyEvent e) {}
			
			public void keyPressed(KeyEvent e) {
				//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				
				if ( e.getKeyCode() == KeyEvent.VK_P) {
					
					play();
					pantallaJ.actualiceBotonPausa(play);
				}
				
			}
		});
		*/
		//setFocusable(true);
        //requestFocusInWindow();
        
	}
	
	public void moverPlatDer(){
		
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
