package presentacion;

import javax.swing.*;
import java.awt.*;

public class myButton  extends JButton {
	
	private Color botonColor; 
	private int font;
	
	public myButton(String title) {
		super(title);
		font = 18;
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		prepareBoton();
        
	}
	
	private void prepareBoton() {
		setForeground(Color.RED);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("Courier New",Font.PLAIN,font));
		setBackground(botonColor);
        revalidate();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	
	
	public void setBotonColor(Color color) {
		botonColor = color;
		prepareBoton();
	}
	
	public void setFontSize(int font) {
		this.font = font;
		prepareBoton();
	}
	
}
