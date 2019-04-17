package aplicacion;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;

public class Plataforma {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int velocity;
	private Rectangle leftBorder,rigthBorder;
	private Rectangle shape;
	
	public Plataforma(int x,int y) {
		xPosition=x;
		yPosition=y;
		height=10;
		width=30;
		createBorders();
		shape=new Rectangle(x,y,width,height);
		velocity=5;
	}
	private void createBorders() {
		leftBorder=new Rectangle(xPosition,yPosition,width/2,height);
		rigthBorder=new Rectangle(xPosition+width/2,yPosition,width/2,height);
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
		createBorders();
	}
	public void moveLeft() {
		yPosition-=velocity;
		shape.setLocation(xPosition, yPosition);
		createBorders();
	}
	public boolean collision(RectangularShape inShape) {
		return inShape.intersects(shape);
	}
	public boolean collisionRight(RectangularShape inShape) {
		return inShape.intersects(rigthBorder);
	}
	public boolean collisionLeft(RectangularShape inShape) {
		return inShape.intersects(leftBorder);
	}
}
