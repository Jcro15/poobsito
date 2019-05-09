package aplicacion;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.Color;
import java.io.*;
/**
 * La clase representa un bloque, definido por un rectangulo con coordenadas (xPosition,yPosition)
 * un alto y un ancho(height,width) un color y una velocidad
 *@author Juan Camilo Rojas & Juan Camilo Angel
 *
 */

public class Plataforma implements Serializable {
	private double xPosition;
	private double yPosition;
	private int height;
	private int width;
	protected int uses;
	protected double velocity;
	private Rectangle2D.Double shape;
	private Color color;
	private String colorString;
	private Arkapoob tablero;
	
	public static final int MAXW=200;
	public static final int MINW=80;
	/**
	 * construye un objeto de tipo plataforma en una posicion dada con un ancho y alto por defecto
	 * @param x la posicion x inicial de la plataforma
	 * @param y la posicion y inicial de la plataforma
	 */
	public Plataforma(double x,double y,Arkapoob tablero) {
		xPosition=x;
		yPosition=y;
		height=10;
		width=120;
		uses=0;
		shape=new Rectangle2D.Double(xPosition, yPosition, width, height);
		velocity=0.6;
		this.tablero=tablero;
	}
	public Plataforma(double x,double y,Arkapoob tablero,int height,int width) {
		this(x, y, tablero);
		this.height=height;
		this.width=width;
		shape=new Rectangle2D.Double(xPosition, yPosition, width, height);
	}
	
	/**
	 * retorna la posicion x que tiene la plataforma en el tablero como un entero
	 * @return la posicion x que tiene la plataforma en el tablero
	 */
	public double getX() {
		return xPosition;
	}
	
	/**
	 * retorna la posicion y que tiene la plataforma en el tablero como un entero
	 * @return la posicion y que tiene la plataforma en el tablero
	 */
	public double getY() {
		return yPosition;
	}
	
	/**
	 * retorna el un objeto Rectangle que representa geometricamente a la plataforma
	 * @return el rectangulo que representa a la plataforma
	 */
	public Rectangle2D.Double getShape() {
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
			shape=new Rectangle2D.Double(xPosition, yPosition, width, height);
		}
	}
	
	/**
	 * mueve la plataforma hacia la izquierda tanto como diga su velocidad
	 */
	public void moveLeft() {
		if(canMoveLeft()) {
		xPosition-=velocity;
		shape=new Rectangle2D.Double(xPosition, yPosition, width, height);
		
		}
	}

	/**
	 * retorna el numero veces que se puede usar la habilidad de la plataforma, si el numero es negativo la plataforma tiene infinitos turnos
	 * @return el numero de turnos restantes en los que se puede usar la plataforma
	 */
	public int getUses() {
		return uses;
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
	 * detecta si hay una colision entre el objeto entrante y la parte derecha de la plataforma
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
	
	/**
	 * establece el string que representa el color de la plataforma
	 * @param colorString el color que se le dara a la plataforma
	 */
	public void setColorString(String colorString){
		this.colorString=colorString;
		
	}
	/**
	 * devuelve el string que representa el color de la plataforma
	 * @return  el color que se le dara a la plataforma
	 */
	public String getColorString(){
		return colorString;
	}
	/**
	 * determina si la plataforma se puede mover hacia la izquierda considerando loss limites del tablero
	 * @return true si se puede mover;false sino
	 */
	protected boolean canMoveLeft() {
		return xPosition>=velocity;		
	}
	/**
	 * determina si la plataforma se puede mover hacia la derecha considerando loss limites del tablero
	 * @return true si se puede mover;false sino
	 */
	protected boolean canMoveRight(){
		return xPosition+width+velocity<tablero.getMaxX();
	}
	/**
	 * aumenta el tamano de la barra siempre y cuando este por debajo del limite de tamano
	 */
	public void aumentarTamaño() {
		if(width<MAXW) {
			width+=40;
			shape=new Rectangle2D.Double(xPosition, yPosition, width, height);
		}
	}
	/**
	 * disminuye el tamano de la barra siempre y cuando este por encima del limite de tamano
	 */
	public void disminuirTamaño() {
		if(width>MINW) {
			width-=40;
			shape=new Rectangle2D.Double(xPosition, yPosition, width, height);
		}
	}
	/**
	 * activa la habilidad de la plataforma,este tipo de plataforma no cuenta con una habilidad
	 */
	public void usarHabilidad() {
	}
	
	/**
	 *describe el comportamiento que tendra la plataforma al colisionar con una bola 
	 * @param bola la bola con la que se genera la colision
	 */
	public void reactToCollision(Bola bola) {
		bola.reactToCollision(this);
	}
	/**
	 * describe el comportamiento que tendra la plataforma al colisionar con otra plataforma 
	 * @param platform la plataforma con la que se genera la colision
	 */
	public void reactToCollision(Plataforma platform) {
		for(int i=0;i<25;i++) {
			if(collisionRight(platform.getShape())) {
				if(canMoveLeft()) moveLeft();
			}
			else {
				if(canMoveRight())moveRight();
			}
		}	
	}

		
	
}
