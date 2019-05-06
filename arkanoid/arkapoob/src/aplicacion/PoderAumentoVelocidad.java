package aplicacion;


public class PoderAumentoVelocidad extends Poder {

	public PoderAumentoVelocidad(Arkapoob tablero,int xPosition,int yPosition) {
		super(tablero,xPosition,yPosition);	
		this.img="/resources/suma1.png";
	}
	public  void reactToCollision(Jugador jugador) {
		tablero.getBola().aumentarVelocidad();
		tablero.removerPoder(this);
	}
	
}
