package aplicacion;

public class PoderAumentarTama�o extends Poder {

	public PoderAumentarTama�o(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}


	public void reactToCollision(Plataforma plataforma) {
		plataforma.aumentarTama�o();
		tablero.removerPoder(this);
	}

}
