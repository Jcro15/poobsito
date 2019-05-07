package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderAumentoVelocidad extends Poder {

	public PoderAumentoVelocidad(Arkapoob tablero,int xPosition,int yPosition) {
		super(tablero,xPosition,yPosition);	
	}
	
	public  void reactToCollision(Jugador jugador) {
		tablero.getBola().aumentarVelocidad();
		tablero.removerPoder(this);
	}
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/suma1.png")).getImage();
		return img;
	}
}
