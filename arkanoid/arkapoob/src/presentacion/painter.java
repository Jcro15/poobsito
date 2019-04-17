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

import aplicacion.*;
public class painter extends JPanel {
	
	private Arkapoob game;
	private Graphics2D g2;
	private Ellipse2D.Double figura;
	
	
	public painter(int w, int h){
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		game=new Arkapoob(w,h);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g2 = (Graphics2D) g ;
		g2.setColor(Color.WHITE);
		figura = game.getBola().getShape();
		g2.fill(figura);
		ArrayList<Bloque> s= game.getBloques();
		for(Bloque i:s) {
			Rectangle  r= i.getShape();
			g2.fill(r);
		}
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
