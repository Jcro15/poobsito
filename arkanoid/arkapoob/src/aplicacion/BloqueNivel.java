package aplicacion;

import java.awt.Color;

public class BloqueNivel extends Bloque {

	public BloqueNivel(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.PINK;
		puntaje=500;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reactToColission(Bola bola) {
		tablero.generarNuevoNivel();
		super.reactToColission(bola);
	}
}
