package aplicacion;

public class PoderAumentarTamaño extends Poder {

	public PoderAumentarTamaño(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}


	public void reactToCollision(Plataforma plataforma) {
		plataforma.aumentarTamaño();
		tablero.removerPoder(this);
	}

}
