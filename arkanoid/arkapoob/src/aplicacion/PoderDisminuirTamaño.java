package aplicacion;


public class PoderDisminuirTamaņo extends Poder {

	public PoderDisminuirTamaņo(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/resta.png";
	}

	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().disminuirTamaņo();
		tablero.removerPoder(this);
	}
	
}
