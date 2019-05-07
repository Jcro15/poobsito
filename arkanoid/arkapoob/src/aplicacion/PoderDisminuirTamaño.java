package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderDisminuirTama�o extends Poder {

	public PoderDisminuirTama�o(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		Image imagen= new ImageIcon(getClass().getResource("/resources/resta.png")).getImage();
		this.img=imagen;
	}

	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().disminuirTama�o();
		tablero.removerPoder(this);
	}
	
}
