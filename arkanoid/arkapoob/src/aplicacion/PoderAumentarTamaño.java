package aplicacion;



public class PoderAumentarTama�o extends Poder {

	public PoderAumentarTama�o(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/suma.png";
	}


	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().aumentarTama�o();
		tablero.removerPoder(this);
	}
	
	

}
