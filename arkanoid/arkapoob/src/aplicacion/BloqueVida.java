package aplicacion;

import java.awt.Color;

public class BloqueVida extends Bloque {

	public BloqueVida(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.YELLOW;
		puntaje=300;
	}
	public void reactToColission(Bola bola) {
		tablero.sumarVidaJugador();
		super.reactToColission(bola);
	}

}
