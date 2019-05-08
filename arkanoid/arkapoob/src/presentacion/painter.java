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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Image;

import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;




import aplicacion.*;

public class painter extends JPanelB {
	
	private Arkapoob game;
	private Graphics2D g2;
	private Ellipse2D.Double figura;
	private pantallaJuego pantallaJ;
	private boolean play;
	private Timer elementosTimer;
	private Timer juegoTimer;
	private boolean p1Izq, p1Der = false;
	private Color colorBola, colorPlata;
	private int jugadores;
	
	
	public painter(int jugadores,int w, int h,pantallaJuego pantallaJ){
		this.pantallaJ=pantallaJ;
		this.jugadores=jugadores;
		setBackground(new ImageIcon(getClass().getResource("/resources/fondo1.png")));
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		play = true;
		game=new Arkapoob(jugadores,w,h);
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
		
		
		elementosTimer = new Timer(3,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				movePlat();
				game.moverElementos();
				repaint();
				//paint(getGraphics());
				
			}
		});
		elementosTimer.start();
		
		
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
				
				if ( e.getKeyCode() == KeyEvent.VK_P) {
					pantallaJ.actualiceBotonPausa(!play);
					pantallaJ.play();
					
					
				}
				
			}
		});
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				
				if ( e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					game.usarHabilidadJugador(0);
					
				}
				
			}
		});
		
		
		//setFocusable(true);
        //requestFocusInWindow();
    }
	
	public void moverPlatDer(){
		game.moverPlataformaDerecha(0);
	}
	
	public void moverPlatIzq(){
		game.moverPlataformaIzquierda(0);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g2 = (Graphics2D) g ;
		g2.setColor(Color.WHITE);
		figura = game.getBola().getShape();
		g2.fill(figura); // dibuja bola
		Jugador j = game.getJugador(0);
		Plataforma p = j.getPlatform();
		Rectangle2D.Double pla = p.getShape();
		g2.setColor(setColorPlataforma(pantallaJ.getColorPlataforma()));
		g2.fill(pla); //dibuja plataforma
		ArrayList<Bloque> s= game.getBloques();
		ArrayList<Poder> poderes=game.getPoderes();
		for(Bloque i:s) {
			Rectangle  r= i.getShape();
			g2.setColor(i.getColor());
			g2.fill(r); //dibuja bloques
		}
		for(Poder pp:poderes) {
			g2.drawImage(pp.getImage(),(int)pp.getX(), (int)pp.getY(),this);
		}
	}
	
	public void play() {
		if(play) {
			play = false;
			elementosTimer.stop();
			juegoTimer.stop();
		}
		else {
			play = true;
			elementosTimer.start();
			juegoTimer.start();
		}
	}
	
	public void cierre() {
		elementosTimer.stop();
		juegoTimer.stop();
	}
	
	public Arkapoob getGame(){
		return game;
	}
	
	private void detengase() {
		cierre();
		if (game.isGameOver()){
			ImageIcon perdiste = new ImageIcon(getClass().getResource("/resources/perder.png"));
			JOptionPane.showMessageDialog(pantallaJ, "Perdiste!","Mensaje",JOptionPane.INFORMATION_MESSAGE, perdiste);
		}
		else if (game.playerWin()) {
			ImageIcon ganaste = new ImageIcon(getClass().getResource("/resources/ganar.png"));
			JOptionPane.showMessageDialog(pantallaJ, "Ganaste!","Mensaje",JOptionPane.INFORMATION_MESSAGE, ganaste);
		}
		pantallaJ.cerrar();
	}
	
	public void refresqueDatos(){
		pantallaJ.actualiceDatos();
	}
	
	public void updName(String name){
		game.getJugador(0).setName(name);
	}
	
	public Color setColorPlataforma(String color){
		Color colorP=null;
		if(color.equals("Verde")){
			colorP=Color.GREEN;
		}
		else if(color.equals("Azul")){
			colorP=Color.BLUE;
			
		}
		else if(color.equals("Amarillo")){
			colorP=Color.YELLOW;
			
		}
		else if(color.equals("Rojo")){
			colorP=Color.RED;
			
		}
		game.getJugador(0).getPlatform().setColor(colorP);
		
		
		return colorP;
	}
	
	public void jugar(){
		elementosTimer.start();
		juegoTimer.start();
		game.moverElementos();
		repaint();
	}
	
	public void salvar(File file) throws ArkapoobException{
		game.salvar(file);
		
	}
	public void updColor(String color){
		game.getJugador(0).getPlatform().setColorString(color);
		
	}
	
	public void abrir(File file) throws ArkapoobException{
		game = game.abrir(file);
	}
}
