package aplicacion;
import javax.swing.ImageIcon;

import java.awt.Image;
/**
 * Representa un poder con la habilidad de convertir la plataforma del jugador en una plataforma pegajosa
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PoderCambioPegajosa extends Poder {

	public PoderCambioPegajosa( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		// TODO Auto-generated constructor stub
	
	
	}

	@Override
	/**
	 * Describe como se comporta el poder al reaccionar con el jugador, este poder 
	 * transforma la plataforma del jugador en una plataforma pegajosa
	 *@param jugador el jugador con el que se colisiona 
	 */
	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaPegajosa(p.getX(),p.getY(), p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/pegajosa.png")).getImage();
		return img;
	}

}
