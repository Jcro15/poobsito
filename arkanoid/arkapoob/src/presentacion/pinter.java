package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import aplicacion.Arkapoob;
public class pinter extends JPanel {
	
	private Arkapoob game;
	private int width;
	private int height;
	private Graphics2D g2;
	private Ellipse2D.Double figura;
	
	
	public pinter(int w, int h){
		width = w;
		height = h;
		setBackground(Color.BLACK);
		game=new Arkapoob(w,h);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g2 = (Graphics2D) g ;
		g2.setColor(Color.WHITE);
		figura = game.getBola().getShape();
		g2.fill(figura);	
	}
	public void play() {
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		game.moverBola();
		paint(getGraphics());
	}
	
	
}
