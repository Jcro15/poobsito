package aplicacion;

public class PoderDisminuirTamaño extends Poder {

	public PoderDisminuirTamaño(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	public void reactToCollision(Plataforma plataforma) {
		plataforma.disminuirTamaño();
		tablero.removerPoder(this);
	}

}
