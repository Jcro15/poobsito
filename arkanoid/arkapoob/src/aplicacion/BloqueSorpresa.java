package aplicacion;

import java.awt.Color;
import java.util.Random;
import java.io.*;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * representa un bloque que tiene la habilidad de generar poderes
 * @author @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class BloqueSorpresa extends Bloque {
	public BloqueSorpresa( int x, int y) {
		super(x, y);
		color=Color.BLUE;
		puntaje=300;
	}
	@Override
	/**
	 * antes de destruirse genera un poder
	 * @param bola la bola que genera la colision
	 */
	public void reactToColission(Bola bola){
		Arkapoob tablero=Arkapoob.demeTablero();
		prepareSonido();
		Random random = new Random();
		int num = random.nextInt(6);
		if (num==0) tablero.anadirPoder(new PoderAumentarTamano(xPosition,yPosition));
		else if(num==1) tablero.anadirPoder(new PoderAumentoVelocidad(xPosition,yPosition));
		else if(num==2) tablero.anadirPoder(new PoderDisminuirTamano(xPosition,yPosition));
		else if(num==3) tablero.anadirPoder(new PoderDisminuirVelocidad(xPosition,yPosition));
		else if(num==4) tablero.anadirPoder(new PoderCambioEspecial(xPosition,yPosition));
		else if(num==5) tablero.anadirPoder(new PoderCambioPegajosa(xPosition,yPosition));
		super.reactToColission(bola);	
	}
}
