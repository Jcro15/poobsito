package aplicacion;

import java.awt.geom.RectangularShape;

public class Jugador {
	private int lives;
	private int score;
	private String name;
	private Plataforma platform;
	
	public Jugador(String name) {
		this.name=name;
		lives=3;
		score=0;
		platform=new Plataforma(100, 587);//temporal mientras se decide donde colocarla inicialmente
	}
	public int getLives() {
		return lives;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public Plataforma getPlatform() {
		return platform;
	}
	public void moverPlataformaDerecha() {
		platform.moveRight();
	}
	public void moverPlataformaIzquierda() {
		platform.moveLeft();
	}
	public boolean collisionRight(RectangularShape inShape) {
		return platform.collisionRight(inShape);
	}
	public boolean collisionLeft(RectangularShape inShape) {
		return platform.collisionLeft(inShape);
	}
	
}
