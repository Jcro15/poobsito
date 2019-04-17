package aplicacion;
import java.awt.Rectangle;

public class Plataforma {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int velocity;
	private Rectangle shape;
	
	public Plataforma(int x,int y) {
		xPosition=x;
		yPosition=y;
		height=10;
		width=30;
		shape=new Rectangle(x,y,width,height);
		velocity=5;
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
	public void moveRight() {
		xPosition+=velocity;
		shape.setLocation(xPosition, yPosition);
	}
	public void moveLeft() {
		yPosition-=velocity;
		shape.setLocation(xPosition, yPosition);
	}
}
