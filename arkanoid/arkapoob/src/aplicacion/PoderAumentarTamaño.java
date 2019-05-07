package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderAumentarTama�o extends Poder {

	public PoderAumentarTama�o(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
		
	}


	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().aumentarTama�o();
		tablero.removerPoder(this);
	}
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/suma.png")).getImage();
		return img;
	}
	
	

}
