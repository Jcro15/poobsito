package aplicacion;

import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public abstract class Poder implements Serializable {
	
	private int xPosition;
	private int yPosition;
	private Ellipse2D.Double shape;
	protected Arkapoob tablero;
	public Poder(Arkapoob tablero,int xPosition,int yPosition) {
		this.tablero=tablero;
		this.xPosition=xPosition;
		this.yPosition=yPosition;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
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
	public abstract void reactToCollision(Plataforma plataforma);
	
	public boolean move() {
		boolean fuera=testBorder();
		if(!fuera) {
			yPosition+=1;
			shape=new Ellipse2D.Double(xPosition,yPosition,10,10);	
		}
		return !fuera;
	}
	public boolean testBorder() {
		return yPosition>tablero.getMaxY(); 
	}
}
	
