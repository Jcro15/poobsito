package aplicacion;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import java.awt.Color;
/**
 * La clase representa un bloque, definido por un rectangulo con coordenadas (xPosition,yPosition)
 * un alto y un ancho(height,width) un color y una velocidad
 *@author Juan Camilo Rojas & Juan Camilo Angel
 *
 */

public class Plataforma {
	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private int velocity;
	private Rectangle shape;
	private Color color;
	private Arkapoob tablero;
	
	/**
	 * construye un objeto de tipo plataforma en una posicion dada con un ancho y alto por defecto
	 * @param x la posicion x inicial de la plataforma
	 * @param y la posicion y inicial de la plataforma
	 */
	public Plataforma(int x,int y,Arkapoob tablero) {
		xPosition=x;
		yPosition=y;
		height=10;
		width=120;
		shape=new Rectangle(x,y,width,height);
		velocity=1;
		this.tablero=tablero;
	}
	
	/**
	 * retorna la posicion x que tiene la plataforma en el tablero como un entero
	 * @return la posicion x que tiene la plataforma en el tablero
	 */
	public int getX() {
		return xPosition;
	}
	
	/**
	 * retorna la posicion y que tiene la plataforma en el tablero como un entero
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
	 * retorna la altura de la plataforma como un entero
	 * @return la altura de la plataforma
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * retorna el ancho de la plataforma como un entero
	 * @return el ancho  de la plataforma
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * mueve la plataforma hacia la derecha tanto como diga su velocidad
	 */
	public void moveRight() {
		if(canMoveRight()) {
			xPosition+=velocity;
			shape.setLocation(xPosition, yPosition);
		}
	}
	
	/**
	 * mueve la plataforma hacia la izquierda tanto como diga su velocidad
	 */
	public void moveLeft() {
		if(canMoveLeft()) {
		xPosition-=velocity;
		shape.setLocation(xPosition, yPosition);
		}
	}
	
	/**
	 * detecta si hay una colision entre el objeto entrante y la plataforma
	 * @param inShape la figura geometrica que representa a la figura entrante 
	 * @return true si hay colision;false si no
	 */
	public boolean collision(RectangularShape inShape) {
		return inShape.getBounds2D().intersects(shape.getBounds2D());
	}
	
	/**
	 * detecta si hay una colision entre el objeto entrante y la parte derecha de laplataforma
	 * @param inShape inShape la figura geometrica que representa a la figura entrante 
	 * @return true si hay colision;false si es una colision con la parte izquierda
	 */
	public boolean collisionRight(RectangularShape inShape) {
		return inShape.getCenterX()>=shape.getCenterX();
	}
	
	/**
	 * establece el color de la plataforma
	 * @param color el color que se le dara a la plataforma
	 */
	public void setColor(Color color){
		this.color=color;
	}
	private boolean canMoveLeft() {
		return xPosition>=1;		
	}
	private boolean canMoveRight(){
		return xPosition+width+1<tablero.getMaxX();
	}
}
