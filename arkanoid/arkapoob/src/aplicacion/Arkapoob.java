package aplicacion;

public class Arkapoob {
	private Bola bola;
	private Jugador jugador;
	private int maxX;
	private int maxY;
	
	public Arkapoob(int maxX ,int maxY) {
		this.maxX=maxX;
		this.maxY=maxY;
		bola=new Bola(500 , 500, 10);//temporal
	}
	public Bola getBola(){
		return bola;
	}
	public void moverBola() {
		bola.outOfHorizontal(maxX);
		bola.outOfVertical(maxY);
		bola.move();
	}
}
