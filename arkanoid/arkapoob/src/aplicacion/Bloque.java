package aplicacion;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class Bloque {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int resistance;
	private Rectangle shape;
	private Rectangle upBorder,downBorder,rightBorder,leftBorder;
	private Color color;
	
	public Bloque(int x, int y) {
		xPosition=x;
		yPosition=y;
		resistance=1;
		height=20;
		width=40;
		shape=new Rectangle(xPosition,yPosition, width, height);
		upBorder=new Rectangle(xPosition,yPosition,width, 1);
		downBorder=new Rectangle(xPosition, yPosition+height-1,width, 1);
		rightBorder=new Rectangle(xPosition+width-1, yPosition, 1, height);
		leftBorder=new Rectangle(xPosition, yPosition, 1, height );
		
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
	public Color getColor() {
		return color;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public boolean destroyed() {
		return resistance==0;
	}
	public void reduceResistance(int damage) {
		resistance-=damage;
	}
	public boolean collision(RectangularShape inShape) {
		return inShape.intersects(shape);
	}
	public boolean verticalCollision(RectangularShape inShape) {
		return inShape.intersects(upBorder)||inShape.intersects(downBorder);
	}
	public boolean horizontalCollision(RectangularShape inShape) {
		return inShape.intersects(rightBorder )||inShape.intersects(leftBorder);
	}
	
}
