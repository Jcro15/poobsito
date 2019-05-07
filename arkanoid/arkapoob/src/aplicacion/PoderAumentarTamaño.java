package aplicacion;

import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderAumentarTamaño extends Poder {

	public PoderAumentarTamaño(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		Image imagen= new ImageIcon(getClass().getResource("/resources/suma.png")).getImage();
		this.img=imagen;
	}


	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().aumentarTamaño();
		tablero.removerPoder(this);
	}
	
	

}
