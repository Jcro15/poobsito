package aplicacion;

public class PoderDisminuirTama�o extends Poder {

	public PoderDisminuirTama�o(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	public void reactToCollision(Plataforma plataforma) {
		plataforma.disminuirTama�o();
		tablero.removerPoder(this);
	}

}
