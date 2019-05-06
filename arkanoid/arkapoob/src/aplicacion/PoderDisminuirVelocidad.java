package aplicacion;


public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		this.img="/resources/resta1.png";
	}
	public  void reactToCollision(Jugador jugador) {
		tablero.getBola().disminuirVelocidad();
		tablero.removerPoder(this);
	}
	
	

}
