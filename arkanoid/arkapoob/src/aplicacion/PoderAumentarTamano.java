package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Representa un poder con la habilidad de aumentar el tamaño de la plataforma
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PoderAumentarTamano extends Poder {

	public PoderAumentarTamano( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
		
	}
	@Override
	/**
	 * 
	 * Describe como se comporta el poder al reaccionar con el jugador, este poder 
	 * aumenta el tamaño de la plataforma del jugador con el que colisiona
	 * @param jugador el jugador con el que se colisiona
	 */
	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		jugador.getPlatform().aumentarTamaño();
		tablero.removerPoder(this);
	}
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/suma.png")).getImage();
		return img;
	}
	
	

}
