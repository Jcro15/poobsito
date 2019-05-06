package aplicacion;



public class PoderAumentarTamaño extends Poder {

	public PoderAumentarTamaño(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/suma.png";
	}


	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().aumentarTamaño();
		tablero.removerPoder(this);
	}
	
	

}
