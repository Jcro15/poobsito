package aplicacion;

import java.awt.Color;
import java.util.Random;

public class BloqueSorpresa extends Bloque {

	public BloqueSorpresa(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.BLUE;
		puntaje=300;
		
	}
	public void reactToColission(Bola bola){
		Random random = new Random();
		int num = random.nextInt(4);
		if (num==0) {
			tablero.aņadirPoder(new PoderAumentarTamaņo(tablero,xPosition,yPosition));
		}
		else if(num==1) {
			tablero.aņadirPoder(new PoderAumentoVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==2) {
			tablero.aņadirPoder(new PoderDisminuirTamaņo(tablero,xPosition,yPosition));
		}
		else if(num==3) {
			tablero.aņadirPoder(new PoderDisminuirVelocidad(tablero,xPosition,yPosition));
		}
		super.reactToColission(bola);
	}

}
