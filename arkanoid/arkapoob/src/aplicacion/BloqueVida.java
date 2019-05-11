package aplicacion;

import java.awt.Color;
/**
 * representa un bloque que tiene la habilidad de aumenta las vidas de los jugadores
 * @author @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class BloqueVida extends Bloque {

	public BloqueVida( int x, int y) {
		super( x, y);
		color=Color.YELLOW;
		puntaje=300;
	}
	@Override
	/**
	 * antes de destruirse aumenta las vidas de los jugadores
	 * @param bola la bola que genera la colision
	 */
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		tablero.sumarVidaJugadores();
		super.reactToColission(bola);
	}

}
