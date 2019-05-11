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
	 * crea un nuevo poder en las coordenadas dadas
	 * @param xPosition coordenada x del poder
	 * @param yPosition coordenada y del poder
	 */
	public Poder(int xPosition,int yPosition) {
		this.xPosition=xPosition;
		this.yPosition=yPosition;
		shape=new Ellipse2D.Double(xPosition,yPosition,20,20);
	}
	/**
	 * returna la figura geometrica que representa al poder
	 * @return una ellipse 2d.double que representa al poder
	 */
	public final  Ellipse2D.Double getShape(){
		return shape;
	}
	/**
	 * retorna la coordenada x del poder
	 * @return la coordenada x del poder
	 */
	public final int getX() {
		return xPosition;
	}
	/**
	 * retorna la coordenada y del poder
	 * @return la coordenada y del poder
	 */
	public final int getY() {
		return yPosition;
	}
	public abstract void reactToCollision(Jugador jugador);
	
	/**
	 * mueve la platafomra una unidad hacia abajo
	 * @return false si se encuentra fuera del limite del tablero;true sino
	 */
	public boolean move() {
		boolean fuera=testBorder();
		if(!fuera) {
			yPosition+=1;
			shape=new Ellipse2D.Double(xPosition,yPosition,20,20);	
		}
		return !fuera;
	}
	/**
	 * verifica si el poder se encuentra dentro de los limites del tablero
	 * @return true si se encuentra dentro de los limites;false sino
	 */
	public boolean testBorder() {
		Arkapoob tablero= Arkapoob.demeTablero();
		return yPosition>tablero.getMaxY(); 
	}
	public abstract Image getImage(); 
	

}
	
