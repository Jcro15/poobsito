package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

import aplicacion.Arkapoob;
public class pinter extends JPanel {
	
	private Arkapoob game;
	private int width;
	private int height;
	
	
	public pinter(int w, int h){
		width = w;
		height = h;
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g2 = (Graphics2D) g ;
		g2.setColor(Color.WHITE);
		figura = game.getBola().getFigura();
		g2.fill(figura);
		
	}
	
	
}
