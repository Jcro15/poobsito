package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderDisminuirVelocidad extends Poder {

	public PoderDisminuirVelocidad(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		
		Image imagen= new ImageIcon(getClass().getResource("/resources/resta1.png")).getImage();
		this.img=imagen;
	}
	public  void reactToCollision(Jugador jugador) {
		tablero.getBola().disminuirVelocidad();
		tablero.removerPoder(this);
	}
	
	

}
