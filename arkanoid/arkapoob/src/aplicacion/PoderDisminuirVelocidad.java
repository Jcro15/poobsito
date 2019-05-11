package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		
		
		
	}
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
