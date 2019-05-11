package aplicacion;

import java.awt.Color;
/**
 * representa un bloque que tiene la habilidad de convertirse en el ultimo bloque eliminado
 * @author @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class BloqueCamaleon extends Bloque {
	

	public BloqueCamaleon( int x, int y) {
		super( x, y);
		color=Color.BLACK;
		puntaje=600;
	}
	@Override
	/**
	 * antes de destruirse genera un nuevo bloque del tipo que fue el ultimo bloque que se elimino en la partida
	 * @param bola la bola que genera la colision
	 */
	public void reactToColission(Bola bola) {
		Arkapoob tablero=Arkapoob.demeTablero();
		String nuevo=tablero.getUltimoBloqueEliminado();
		if (!nuevo.equals("")) {
			try {
				Class <?> clase = Class.forName("aplicacion."+nuevo);
				Object o = clase.getDeclaredConstructor(int.class,int.class).newInstance(xPosition,yPosition);
				tablero.anadirBloque((Bloque)o);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		super.reactToColission(bola);
		tablero.setUltimoBloqueEliminado(nuevo);
	}

}
