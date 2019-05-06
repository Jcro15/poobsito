package aplicacion;


public class PoderDisminuirTama�o extends Poder {

	public PoderDisminuirTama�o(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/resta.png";
	}

	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().disminuirTama�o();
		tablero.removerPoder(this);
	}
	
}
