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
	private Timer juegoTimer;
	private boolean p1Izq, p1Der = false;
	
	
	public painter(int w, int h,pantallaJuego pantallaJ){
		this.pantallaJ=pantallaJ;
		setBackground("fondo1.png");
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		play = true;
		game=new Arkapoob(w,h);
		setFocusable(true);
		prepareAcciones();
		
		juegoTimer = new Timer(15, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refresqueDatos();
				
					if (game.isGameOver() || game.playerWin()){
						detengase();
					}
				
			}

		});
		juegoTimer.start();
		
		
		playerTimer = new Timer(20,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movePlat();
				
				game.moverBola();
				repaint();
				//paint(getGraphics());
				
			}
		});
		playerTimer.start();
		
		
	}
	private void movePlat() {
		//System.out.println("ddd");
		if (p1Der) {
			moverPlatDer();
		}
		if (p1Izq) {
			moverPlatIzq();
		}
	}
	
	private void prepareAcciones() {
		
		setFocusable(true);
		
        //requestFocusInWindow();
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "Der1down");
		getActionMap().put("Der1down", new AbstractAction() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				p1Der = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "Der1up");
		getActionMap().put("Der1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				
				p1Der = false;
			}
		});


		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "Izq1down");
		getActionMap().put("Izq1down", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p1Izq = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "Izq1up");
		getActionMap().put("Izq1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				p1Izq = false;
			}
		});

		
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
			juegoTimer.stop();
		}
		else {
			play = true;
			playerTimer.start();
			juegoTimer.start();
		}
		
	}
	
	public void cierre() {
		playerTimer.stop();
		juegoTimer.stop();
	}
	public Arkapoob getGame(){
		
		return game;
	}
	private void detengase() {
		
		pantallaJ.cerrar();
		
		
	}
	public void refresqueDatos(){
		pantallaJ.actualiceDatos();
		
	}
	
	
	
	
}
