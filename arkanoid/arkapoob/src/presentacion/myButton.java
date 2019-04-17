package presentacion;

import javax.swing.*;
import java.awt.*;

public class myButton  extends JButton {
	/**
	private Color botonColor; 
	private int font;
	*/
	
	public myButton(Icon icono){
		super(icono);
	}
	
	public void setIcon(ImageIcon icono){
		super.setIcon(icono);
		
	}
	/**
	public myButton(String msg) {
		super(msg);
		setFocusable(false);
		botonColor = new Color(2,164,46);
		font = 18;
		super.setContentAreaFilled(false);
		prepareBoton();
        
        
	}
	
	private void prepareBoton() {
		setForeground(Color.BLACK);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("Courier New",Font.PLAIN,font));
		setBackground(botonColor);
        revalidate();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	*/
	
	public void setTransparent(){
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);
	}
	
	
	
}
