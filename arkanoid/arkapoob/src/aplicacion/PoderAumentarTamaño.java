package aplicacion;



public class PoderAumentarTamaņo extends Poder {

	public PoderAumentarTamaņo(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.img="/resources/suma.png";
	}


	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().aumentarTamaņo();
		tablero.removerPoder(this);
	}
	
	

}
