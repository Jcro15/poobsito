package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		
		
		
	}
	public  void reactToCollision(Jugador jugador) {
		tablero.getBola().disminuirVelocidad();
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/resta1.png")).getImage();
		return img;
	}
}
