package aplicacion;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
/**
 * la clase representa una plataforma, definida por un rectangulo con coordenadas (xPosition,yPosition)
 * un alto y un ancho(height,width) y una velocidad 
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Plataforma {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int velocity;
	private Rectangle shape;
	
	/**
	 * construye una nueva plataforma en las coordenadas x ,y
	 * @param x la coordenada x donde se creara la plataforma
	 * @param y la coordenada y donde se creara la plataforma
	 */
	public Plataforma(int x,int y) {
		xPosition=x;
		yPosition=y;
		height=10;
		width=120;
		shape=new Rectangle(x,y,width,height);
		velocity=1;
	}
	/**
	 * retorna la posicion x que tiene la esquina superior izquierda de la 
	 * plataforma en el tablero como un entero
	 * @return la posicion x que tiene la plataforma en el tablero
	 */
	public int getX() {
		return xPosition;
	}
	/**
	 * retorna la posicion y que tiene la esquina superior izquierda de la 
	 * plataforma en el tablero como un entero
	 * @return la posicion y que tiene la plataforma en el tablero
	 */
	public int getY() {
		return yPosition;
	}
	/**
	 * retorna el un objeto Rectangle que representa geometricamente a la plataforma
	 * @return el rectangulo que representa a la plataforma
	 */
	public Rectangle getShape() {
		return shape;
	}
	/**
	 * retorna el alto de la plataforma
	 * @return el alto de la plataforma
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * retorna el ancho de la plataforma como un entero
	 * @return el ancho de la plataforma 
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * mueve la plataforma  hacia la derecha
	 */
	public void moveRight() {
		xPosition+=velocity;
		shape.setLocation(xPosition, yPosition);
	}
	/**
	 * mueve la plataforma hacia la izquierda
	 */
	public void moveLeft() {
		xPosition-=velocity;
		shape.setLocation(xPosition, yPosition);
	}
	/**
	 * Detecta si existe una colision entre la plataforma y un objeto entrante 
	 * @param inShape la figura geometrica que representa al objeto entrante
	 * @return true si existe colision ; false sino
	 */
	public boolean collision(RectangularShape inShape) {
		return inShape.intersects(shape);
	}
	/**
	 * Detecta si la colision entre la plataforma y el objeto se genera en la parte derecha o izquierda de la plataforma
	 * @param inShape la figura geometrica que representa al objeto entrante
	 * @return true si la colision se genera del lado derecho de la plataforma;false si se genera del lado izquierdo
	 */
	public boolean collisionRight(RectangularShape inShape) {
		return inShape.getCenterX()>=shape.getCenterX();
	}
}
