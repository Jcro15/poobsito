package aplicacion;
import java.io.*;
import java.awt.*;
import java.awt.geom.RectangularShape;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * la clase representa un bloque, definido por un rectangulo con coordenadas (xPosition,yPosition)
 * un alto y un ancho(height,width) un color y un puntaje 
 * que da al momento de ser destruido
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Bloque implements Serializable{
	protected int xPosition;
	protected int yPosition;
	protected int height;
	protected int width;
	protected int resistance;
	protected int puntaje;
	protected Rectangle shape;
	protected Color color;
	protected boolean destroyable;
	protected transient Clip power;
	
	/**
	 * construye un nuevo bloque en las coordenadas x ,y
	 * @param x la coordenada x donde se creara el bloque
	 * @param y la coordenada y donde se creara el bloque
	 */
	public Bloque(int x, int y) {
		xPosition=x;
		yPosition=y;
		resistance=1;
		height=20;
		width=40;
		puntaje=100;
		shape=new Rectangle(xPosition,yPosition, width, height);
		color=Color.RED;
		destroyable=true;
		
	}
	/**
	 * retorna la posicion x que tiene el bloque en el tablero como un entero
	 * @return la posicion x que tiene el bloque en el tablero
	 */
	public int getX() { 
		return xPosition;
	}
	/**
	 * retorna la posicion y que tiene el bloque en el tablero como un entero
	 * @return la posicion y que tiene el bloque en el tablero
	 */
	public int getY() {
		return yPosition;
	}
	/**
	 * retorna el un objeto Rectangle que representa geometricamente al bloque
	 * @return el rectangulo que representa al bloque
	 */
	public Rectangle getShape() {
		return shape;
	}
	/**
	 * retorna un objeto Color que indica el color del bloque
	 * @return el color del bloque
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * retorna un booleano que indica si este bloque se puede destruir
	 * @return true si se puede destruir;false sino
	 */
	public boolean isDestroyable() {
		return destroyable;
	}
	/**
	 * retorna la altura del bloque como un entero
	 * @return la altura del bloque
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * retorna el ancho del bloque como un entero
	 * @return el ancho del bloque
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * evalua si el bloque ha sido destruido, un bloque se considera destruido si su resistencia es 0 
	 * @return true si el bloque ha sido destruido ; false sino
	 */
	public boolean destroyed() {
		return resistance==0;
	}
	/**
	 * reduce la resistencia del bloque cierta cantidad
	 * @param damage la cantidad de resistencia que se disminuira
	 */
	public void reduceResistance(int damage) {
		resistance-=damage;
	}
	/**
	 * Detecta si hay una colision entre el bloque y otro elemento
	 * @param inShape el objeto geometrico que representa al elemento entrante
	 * @return true si existe una colision ; false sino
	 */
	public boolean collision(RectangularShape inShape) {
		return inShape.getBounds2D().intersects(shape.getBounds2D());
	}
	/**
	 * Detecta si hay una colision entre alguno de los margenes verticales y otro elemento
	 * @param inShape  el objeto geometrico que representa al elemento entrante
	 * @return true si existe una colision ; false si es una colision horizontal
	 */
	public boolean verticalCollision(RectangularShape inShape) {
		double interseccionIzquierda = inShape.getMaxX() - shape.getMinX();
		double interseccionDerecha = shape.getMaxX() - inShape.getMinX();
		double interseccionArriba = inShape.getMaxY() - shape.getMinY();
		double interseccionAbajo = shape.getMaxY() - inShape.getMinY();
		double minInterseccionX = Math.min(interseccionIzquierda, interseccionDerecha);
		double minInterseccionY = Math.min(interseccionAbajo, interseccionArriba);
		return minInterseccionY<=minInterseccionX;
	}
	/**
	 * retorna el puntaje que da este bloque al ser destruido
	 * @return el puntaje que da el bloque
	 */
	public int getPuntaje() {
		return puntaje;
	}
	/**
	 * Describe el comportamiento del bloque al colisionar con una bola,
	 * este bloque simplemente se destruye y redirecciona la bola
	 * @param bola la bola con la que se genera la colision
	 */
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		reduceResistance(bola.getDamage());
		bola.reactToCollision(this);
		if (destroyed()) {
			tablero.remove(this);
			tablero.setUltimoBloqueEliminado(this.getClass().getSimpleName());
			tablero.sumarPuntosJugador(getPuntaje());
		}
		
	}
	
	public void prepareSonido(){
		try {
			
			power = AudioSystem.getClip();
			power.open(AudioSystem.getAudioInputStream(new File("sonidos/power.wav")));
			power.loop(0);
		}
		catch (Exception e) {}
	}
	
	
}
