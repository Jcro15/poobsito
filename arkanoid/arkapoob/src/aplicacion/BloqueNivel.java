package aplicacion;

import java.awt.Color;

public class BloqueNivel extends Bloque {

	public BloqueNivel( int x, int y) {
		super( x, y);
		color=Color.PINK;
		puntaje=500;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		tablero.generarNuevoNivel();
		super.reactToColission(bola);
	}
}
