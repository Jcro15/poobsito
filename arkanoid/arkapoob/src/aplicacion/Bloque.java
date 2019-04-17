package aplicacion;

import java.awt.*;

public class Bloque {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int resistance;
	private Rectangle shape;
	private Color color;
	
	public Bloque(int x, int y) {
		xPosition=x;
		yPosition=y;
		resistance=1;
		height=20;
		width=40;
		shape=new Rectangle(xPosition,yPosition, width, height);
		color=Color.RED;
	}
	public int getX() {
		return xPosition;
	}
	public int getY() {
		return yPosition;
	}
	public Rectangle getShape() {
		return shape;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
}
