package aplicacion;

public class PoderAumentoVelocidad extends Poder {

	public PoderAumentoVelocidad(Arkapoob tablero,int xPosition,int yPosition) {
		super(tablero,xPosition,yPosition);	
	}
	public  void reactToCollision(Plataforma plataforma) {
		tablero.getBola().aumentarVelocidad();
		tablero.removerPoder(this);
	}
}
