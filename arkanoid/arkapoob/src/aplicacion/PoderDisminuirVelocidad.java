package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 * Representa un poder con la habilidad de disminuir la velocidad de la bola
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		
		
		
	}
	@Override
	/**
	 * Describe como se comporta el poder al reaccionar con el jugador, este poder 
	 * disminuye la velocidad de la bola
	 *@param jugador el jugador con el que se colisiona 
	 */
	public  void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		tablero.getBola().disminuirVelocidad();
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/resta1.png")).getImage();
		return img;
	}
}
