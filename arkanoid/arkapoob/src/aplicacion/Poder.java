package aplicacion;

import java.awt.geom.Ellipse2D;

public abstract class Poder {
	
	private int xPosition;
	private int yPosition;
	private Ellipse2D.Double shape;
	private Arkapoob tablero;
	public Poder(Arkapoob tablero,int xPosition,int yPosition) {
		this.tablero=tablero;
		this.xPosition=xPosition;
		this.yPosition=yPosition;
	}
	public final  Ellipse2D.Double getShape(){
		return shape;
	}
	public final int getX() {
		return xPosition;
	}
	public final int getY() {
		return yPosition;
	}
	public abstract void reactToCollision();
	
	public void move() {
		yPosition+=1;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
	}
}
	
