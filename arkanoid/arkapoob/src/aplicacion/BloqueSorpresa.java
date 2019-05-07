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
			tablero.añadirPoder(new PoderAumentarTamaño(tablero,xPosition,yPosition));
		}
		else if(num==1) {
			tablero.añadirPoder(new PoderAumentoVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==2) {
			tablero.añadirPoder(new PoderDisminuirTamaño(tablero,xPosition,yPosition));
		}
		else if(num==3) {
			tablero.añadirPoder(new PoderDisminuirVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==4) {
			tablero.añadirPoder(new PoderCambioEspecial(tablero,xPosition,yPosition));
		}
		else if(num==5) {
			tablero.añadirPoder(new PoderCambioPegajosa(tablero,xPosition,yPosition));
		}
		super.reactToColission(bola);
	}

}
