package aplicacion;

import java.awt.geom.RectangularShape;

public class Jugador {
	private int lives;
	private int score;
	private String name;
	private Plataforma platform;
	
	public Jugador() {
		//this.name=name;
		lives=3;
		score=0;
		platform=new Plataforma(300, 640);//temporal mientras se decide donde colocarla inicialmente
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
	
	public void quitarVida() {
		lives-=1;
	}
	
	public boolean collisionRight(RectangularShape inShape) {
		return platform.collisionRight(inShape);
	}
	
	public boolean collision(RectangularShape inShape) {
		return platform.collision(inShape);
	}
	
	public void sumarPuntos(int puntos) {
		score+=puntos;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
}
