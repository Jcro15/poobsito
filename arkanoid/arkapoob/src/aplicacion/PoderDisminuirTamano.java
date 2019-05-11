package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderDisminuirTamano extends Poder {

	public PoderDisminuirTamano( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
	}

	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		jugador.getPlatform().disminuirTamaño();
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/resta.png")).getImage();
		return img;
	}
	
}
