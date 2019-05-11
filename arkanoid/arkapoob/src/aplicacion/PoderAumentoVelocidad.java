package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderAumentoVelocidad extends Poder {

	public PoderAumentoVelocidad(int xPosition,int yPosition) {
		super(xPosition,yPosition);	
	}
	
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
