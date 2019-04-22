package aplicacion;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import java.awt.Color;

public class Plataforma {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int velocity;
	private Rectangle shape;
	private Color color;
	
	public Plataforma(int x,int y) {
		xPosition=x;
		yPosition=y;
		height=10;
		width=120;
		shape=new Rectangle(x,y,width,height);
		velocity=1;
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
		xPosition-=velocity;
		shape.setLocation(xPosition, yPosition);
	}
	public boolean collision(RectangularShape inShape) {
		return inShape.intersects(shape);
	}
	public boolean collisionRight(RectangularShape inShape) {
		return inShape.getCenterX()>=shape.getCenterX();
	}
	
	public void setColor(Color color){
		this.color=color;
	}
}
