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
		int num = random.nextInt(6);
		if (num==0) {
			tablero.a�adirPoder(new PoderAumentarTama�o(tablero,xPosition,yPosition));
		}
		else if(num==1) {
			tablero.a�adirPoder(new PoderAumentoVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==2) {
			tablero.a�adirPoder(new PoderDisminuirTama�o(tablero,xPosition,yPosition));
		}
		else if(num==3) {
			tablero.a�adirPoder(new PoderDisminuirVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==4) {
			tablero.a�adirPoder(new PoderCambioEspecial(tablero,xPosition,yPosition));
		}
		else if(num==5) {
			tablero.a�adirPoder(new PoderCambioPegajosa(tablero,xPosition,yPosition));
		}
		super.reactToColission(bola);
	}

}
