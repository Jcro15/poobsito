package aplicacion;

import java.awt.Color;

public class BloqueVida extends Bloque {

	public BloqueVida( int x, int y) {
		super( x, y);
		color=Color.YELLOW;
		puntaje=300;
	}
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		tablero.sumarVidaJugadores();
		super.reactToColission(bola);
	}

}
