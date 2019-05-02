package aplicacion;

public class PlataformaEspecial extends Plataforma {

	public PlataformaEspecial(int x, int y,Arkapoob tablero) {
		super(x, y,tablero);
	}
	public void moveRight() {
		super.moveLeft();
	}
	public void moveLeft() {
		super.moveRight();
	}
}
