package aplicacion;
import java.awt.geom.*;
/**
 * la clase representa una bola , definida por una elipse con coordenadas (xPosition,yPosition)
 * cuenta con direcciones de movimiento(dx,dy) y el daño que causa a los bloques
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Bola {
	private int xPosition;
	private int yPosition;
	private int dx;
	private int dy;
	private int damage;
	private Ellipse2D.Double shape;
	
	public static final int DERECHA=1;
	public static final int IZQUIERDA=-1;
	public static final int ARRIBA=-1;
	public static final int ABAJO=1;
	
	/**
	 * construye una nueva bola en las coordenadas x ,y
	 * @param x la coordenada x donde se creara la bola
	 * @param y la coordenada y donde se creara la bola
	 */
	public Bola(int x ,int y) {
		xPosition=x;
		yPosition=y;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
		dx=1;
		dy=-1;
		damage=1;
	}
	/**
	 * retorna la figura que representa la bola como un objeto de tipo Ellipse2D.Double
	 * @return la figura geometrica que representa a la bola
	 */
	public Ellipse2D.Double getShape(){
		return shape;
	}
	/**
	 * retorna el valor de daño que hace la bola al impactar un bloque
	 * @return el daño que hace la bola
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * retorna la posicion x que tiene la bola como un entero
	 * @return la posicion x de la bola
	 */
	public int getX() {
		return xPosition;
	}
	/**
	 * retorna la posicion y que tiene la bola como un entero
	 * @return la posicion y de la bola
	 */
	public int getY() {
		return yPosition;
	}
	/**
	 * mueve la bola una unidad en direccion dx y una unidad en direccion dy
	 */
	public void move() {
		xPosition+=dx;
		yPosition+=dy;
		shape=new Ellipse2D.Double(xPosition,yPosition,10,10);
	}

	public int getDx() {
			return dx;
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
	
}
