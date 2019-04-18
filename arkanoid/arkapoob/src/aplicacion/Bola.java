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
	/**
	 * modifica el componente x del movimiento de la bola para que de dirija en la direccion opuesta
	 * a la que anteriormente se movia
	 */
	public void invertXComponent () {
			dx=-dx;
	}
	/**
	 * modifica el componente y del movimiento de la bola para que de dirija en la direccion opuesta
	 * a la que anteriormente se movia
	 */
	public void invertYComponent () {
			dy=-dy;
	}
	/**
	 * Modifica el componente x del movimiento de la bola para que se dirija a la derecha
	 */
	public void setLeft() {
		dx=-1;
	}
	/**
	 * Modifica el componente x del movimiento de la bola para que se dirija a la derecha
	 */
	public void setRight() {
		dx=1;
	}
}
