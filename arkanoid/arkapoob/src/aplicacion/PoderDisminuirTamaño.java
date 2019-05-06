package aplicacion;


public class PoderDisminuirTamaño extends Poder {

	public PoderDisminuirTamaño(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/resta.png";
	}

	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().disminuirTamaño();
		tablero.removerPoder(this);
	}
	
}
