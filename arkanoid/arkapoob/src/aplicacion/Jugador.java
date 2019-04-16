package aplicacion;

public class Jugador {
	private int lives;
	private int score;
	private String name;
	private Plataforma platform;
	
	public Jugador(String name) {
		this.name=name;
		lives=3;
		score=0;
		platform=new Plataforma(0, 0);//temporal mientras se decide donde colocarla inicialmente
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
}
