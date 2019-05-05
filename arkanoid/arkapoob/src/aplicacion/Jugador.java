package aplicacion;

import java.awt.geom.RectangularShape;
import java.io.*;
/**
 * la clase representa un jugador definido por un nombre, unas vidas ,
 *  un puntaje y una plataforma que puede controlar
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class Jugador implements Serializable{
	private int lives;
	private int score;
	private String name;
	private Plataforma platform;
	/**
	 * Construye un nuevo objeto de tipo jugador con un valor por defecto de vidas, de puntaje y una plataforma
	 * en una posicion por defecto
	 */
	public Jugador(Arkapoob tablero) {
		lives=3;
		score=0;
		platform=new Plataforma(202, 620,tablero);
	}
	/**
	 * retorna el numero de vida del jugador
	 * @return el numero de vidas del jugador
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * retorna el nombre del jugador como un string	
	 * @return el nombre del jugador
	 */
	public String getName() {
		return name;
	}
	/**
	 * retorna la puntuacion actual del jugador como un entero
	 * @return la puntuacion actual del jugador
	 */
	public int getScore() {
		return score;
	}
	/**
	 * retorna la plataforma que maneja el jugador como un objeto de tipo Plataforma
	 * @return la plataforma que controla el jugador
	 */
	public Plataforma getPlatform() {
		return platform;
	}
	/**
	 * ordena a la plataforma que se mueva a la derecha
	 */
	public void moverPlataformaDerecha() {
		platform.moveRight();
	}
	/**
	 * ordena a la plataforma que se mueva a la izquierda
	 */
	public void moverPlataformaIzquierda() {
		platform.moveLeft();
	}
	/**
	 * reduce las vidas del jugador
	 */
	public void setVidas(int vidas) {
		lives=vidas;
	}
	/**
	 * ordena a la plataforma a verificar si existe una colision  entre la parte derecha de la barra y
	 * la figura entrante
	 * @param inShape la figura entrante
	 * @return true si existe colision;false si no
	 */
	public boolean collisionRight(RectangularShape inShape) {
		return platform.collisionRight(inShape);
	}
	/**
	 * ordena a la plataforma a verificar si existe una colision entre esta y un objeto entrante
	 * @param inShape la figura entrante
	 * @return true si existe colision;false si no
	 */
	public boolean collision(RectangularShape inShape) {
		return platform.collision(inShape);
	}
	/**
	 * añade una cantidad al puntaje del jugador
	 * @param puntos la cantidad de puntos a añadir
	 */
	public void sumarPuntos(int puntos) {
		score+=puntos;
	}
	/**
	 * establece el nombre del jugador
	 * @param name el nombre que se le quiere dar
	 */
	public void setName(String name){
		this.name = name;
	}
	
	
}
