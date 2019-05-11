package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;
/**
 * Representa un poder con la habilidad de aumentar la velocidad de la bola
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PoderAumentoVelocidad extends Poder {

	public PoderAumentoVelocidad(int xPosition,int yPosition) {
		super(xPosition,yPosition);	
	}
	@Override
	/**
	 * 
	 * Describe como se comporta el poder al reaccionar con el jugador, este poder 
	 * aumenta la velocidad de la bola
	 * @param jugador el jugador con el que se colisiona
	 */
	public  void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		tablero.getBola().aumentarVelocidad();
		tablero.removerPoder(this);
	}
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/suma1.png")).getImage();
		return img;
	}
}
