package aplicacion;

import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.awt.TexturePaint;
import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *la clase representa un poder, definido por una elipse con coordenadas (xPosition,yPosition) 
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public abstract class Poder implements Serializable {
	
	private int xPosition;
	private int yPosition;
	private Ellipse2D.Double shape;
	/**
	 * 
	 * @param xPosition
	 * @param yPosition
	 */
	public Poder(int xPosition,int yPosition) {
		this.xPosition=xPosition;
		this.yPosition=yPosition;
		shape=new Ellipse2D.Double(xPosition,yPosition,20,20);
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
	public abstract void reactToCollision(Jugador jugador);
	
	
	public boolean move() {
		boolean fuera=testBorder();
		if(!fuera) {
			yPosition+=1;
			shape=new Ellipse2D.Double(xPosition,yPosition,20,20);	
		}
		return !fuera;
	}
	public boolean testBorder() {
		Arkapoob tablero= Arkapoob.demeTablero();
		return yPosition>tablero.getMaxY(); 
	}
	public abstract Image getImage(); 
	

}
	
