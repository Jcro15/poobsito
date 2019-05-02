package aplicacion;

import java.awt.Color;

public class BloqueCamaleon extends Bloque {
	

	public BloqueCamaleon(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.BLACK;
		puntaje=600;
	}
	public void reactToColission(Bola bola) {
		String nuevo=tablero.getUltimoBloqueEliminado();
		if (nuevo!="") {
			try {
				Class <?> clase = Class.forName("aplicacion."+nuevo);
				Object o = clase.getDeclaredConstructor(Arkapoob.class,int.class,int.class).newInstance(tablero,xPosition,yPosition);
				tablero.añadirBloque((Bloque)o);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		super.reactToColission(bola);
		tablero.setUltimoBloqueEliminado(nuevo);
	}

}
