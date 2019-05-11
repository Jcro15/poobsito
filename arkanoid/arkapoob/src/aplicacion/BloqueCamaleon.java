package aplicacion;

import java.awt.Color;

public class BloqueCamaleon extends Bloque {
	

	public BloqueCamaleon( int x, int y) {
		super( x, y);
		color=Color.BLACK;
		puntaje=600;
	}
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
