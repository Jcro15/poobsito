package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 * Representa un poder con la habilidad de convertir la plataforma en una plataforma especial
 * @author Juan Camilo Rojas & Juan Camilo Angel
 *
 */
public class PoderCambioEspecial extends Poder {
	public PoderCambioEspecial( int xPosition, int yPosition) {
		super(xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
		
	}

	@Override
	/**
	 * Describe como se comporta el poder al reaccionar con el jugador, este poder 
	 * transforma la plataforma del jugador en una plataforma especial
	 *@param jugador el jugador con el que se colisiona 
	 */
	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaEspecial(p.getX(),p.getY(), p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/especial.png")).getImage();
		return img;
	}

}
