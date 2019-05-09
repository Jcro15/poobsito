package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderAumentarTamano extends Poder {

	public PoderAumentarTamano(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
		
	}


	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().aumentarTamaño();
		tablero.removerPoder(this);
	}
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/suma.png")).getImage();
		return img;
	}
	
	

}
