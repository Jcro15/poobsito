package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderAumentarTamano extends Poder {

	public PoderAumentarTamano( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
		
	}


	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		jugador.getPlatform().aumentarTamaño();
		tablero.removerPoder(this);
	}
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/suma.png")).getImage();
		return img;
	}
	
	

}
