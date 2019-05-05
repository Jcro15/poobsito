package aplicacion;

public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
	}
	public  void reactToCollision(Plataforma plataforma) {
		tablero.getBola().disminuirVelocidad();
		tablero.removerPoder(this);
	}

}
