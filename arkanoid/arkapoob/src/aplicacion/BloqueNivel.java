package aplicacion;

import java.awt.Color;
/**
* representa un bloque que tiene la habilidad de hacer que los jugadores pasen de nivel
* @author @author Juan Camilo Rojas & Juan Camilo Angel
*
*/
public class BloqueNivel extends Bloque {

	public BloqueNivel( int x, int y) {
		super( x, y);
		color=Color.PINK;
		puntaje=500;
		// TODO Auto-generated constructor stub
	}
	@Override
	/**al colisionar genera un nuevo nivel
	 * @param bola la bola que genera la colision
	 */
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		tablero.generarNuevoNivel();
		super.reactToColission(bola);
	}
}
