package aplicacion;
import java.awt.geom.*;
import java.io.*;

/**
 * la clase representa una bola , definida por una elipse con coordenadas (xPosition,yPosition)
 * cuenta con direcciones de movimiento(dx,dy) y el dano que causa a los bloques
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Bola implements Serializable{
	private double xPosition;
	private double yPosition;
	private int dx;
	private int dy;
	private int damage;
	private double velocity;
	private Ellipse2D.Double shape;
	private Arkapoob tablero;
	
	public static final double VMAX=1.2;
	public static final double VMIN=0.6;
	public static final int DERECHA=1;
	public static final int IZQUIERDA=-1;
	public static final int ARRIBA=-1;
	public static final int ABAJO=1;
	public static final int V0=0;
	
	/**
	 * construye una nueva bola en las coordenadas x ,y
	 * @param x la coordenada x donde se creara la bola
	 * @param y la coordenada y donde se creara la bola
	 */
	public Bola(double x ,double y,Arkapoob tablero) {
		xPosition=x;
		yPosition=y;
		velocity=0.8;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
		dx=1;
		dy=-1;
		damage=1;
		this.tablero=tablero;
	}
	/**
	 * retorna la figura que representa la bola como un objeto de tipo Ellipse2D.Double
	 * @return la figura geometrica que representa a la bola
	 */
	public Ellipse2D.Double getShape(){
		return shape;
	}
	/**
	 * retorna el valor de dano que hace la bola al impactar un bloque
	 * @return el dano que hace la bola
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * retorna la posicion x que tiene la bola como un entero
	 * @return la posicion x de la bola
	 */
	public double getX() {
		return xPosition;
	}
	/**
	 * retorna la posicion y que tiene la bola como un entero
	 * @return la posicion y de la bola
	 */
	public double getY() {
		return yPosition;
	}
	
	
	/**
	 * detecta si la bola se enc
	 */
	private void testBorder() {
		if(getX()>tablero.getMaxX()||getX()<0) {
			setDx(getDx()*-1);
		}
		else if(getY()<0) {
			setDy(Bola.ABAJO);
		}
		else if(getY()>tablero.getMaxY()) {
			tablero.setBall();
			tablero.restarVidaJugador();
		}
	}
	
	public void move() {
		testBorder();
		xPosition+=dx*velocity;
		yPosition+=dy*velocity;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
	}

	public int getDx() {
			return dx;
	}
	public void aumentarVelocidad() {
		if(velocity<VMAX)velocity+=0.1;
	}
	public void disminuirVelocidad() {
		if(velocity>VMIN)velocity-=0.1;
	}
	public int getDy() {
			return dy;
	}
	/**
	 * Modifica el componente y del movimiento de la bola (1 abajo -1 arriba)
	 */
	public void setDy(int dir) {
		dy=dir;
	}
	/**
	 * Modifica el componente y del movimiento de la bola (1 derecha -1 izquierda)
	 */
	public void setDx(int dir) {
		dx=dir;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double nv) {
		velocity=nv;
	}
	
	public void reactToCollision(Bloque bloque) {
		int anterior=getDy();
		boolean derecha=shape.getMaxX()>bloque.getX()+bloque.getWidth();
		boolean abajo=shape.getMaxY()>bloque.getY()+bloque.getHeight();
		if(bloque.verticalCollision(getShape())) {
			setDy(abajo?Bola.ABAJO:Bola.ARRIBA);
			if(getDy()==anterior) {
				setDx(derecha? Bola.DERECHA:Bola.IZQUIERDA);
			} 
		}
		else{
			setDx(derecha?Bola.DERECHA:Bola.IZQUIERDA);
		}
	}
	public void reactToCollision(Plataforma plataforma) {
		setDy(Bola.ARRIBA);
		if(plataforma.collisionRight(getShape())) {
			setDx(Bola.DERECHA);
		}
		else {
			setDx(Bola.IZQUIERDA);
		}
	}
}
