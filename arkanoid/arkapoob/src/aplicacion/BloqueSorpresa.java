package aplicacion;

import java.awt.Color;
import java.util.Random;
import java.io.*;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BloqueSorpresa extends Bloque {

	public BloqueSorpresa(Arkapoob tablero, int x, int y) {
		super(tablero, x, y);
		color=Color.BLUE;
		puntaje=300;
		
	}
	public void reactToColission(Bola bola){
		prepareSonido();
		Random random = new Random();
		int num = random.nextInt(6);
		if (num==0) {
			tablero.anadirPoder(new PoderAumentarTamano(tablero,xPosition,yPosition));
		}
		else if(num==1) {
			tablero.anadirPoder(new PoderAumentoVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==2) {
			tablero.anadirPoder(new PoderDisminuirTamano(tablero,xPosition,yPosition));
		}
		else if(num==3) {
			tablero.anadirPoder(new PoderDisminuirVelocidad(tablero,xPosition,yPosition));
		}
		else if(num==4) {
			tablero.anadirPoder(new PoderCambioEspecial(tablero,xPosition,yPosition));
		}
		else if(num==5) {
			tablero.anadirPoder(new PoderCambioPegajosa(tablero,xPosition,yPosition));
		}
		super.reactToColission(bola);
		
	}
	
		
	
}
