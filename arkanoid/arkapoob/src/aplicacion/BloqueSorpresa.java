package aplicacion;

import java.awt.Color;

public class BloqueSorpresa extends Bloque {

	public BloqueSorpresa(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.BLUE;
		puntaje=300;
	}
	public void reactToColission(Bola bola){
		tablero.añadirPoder(new PoderAumentarTamaño(tablero,xPosition,yPosition));
		super.reactToColission(bola);
	}

}
