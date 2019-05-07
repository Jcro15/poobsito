package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderDisminuirTamaņo extends Poder {

	public PoderDisminuirTamaņo(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		Image imagen= new ImageIcon(getClass().getResource("/resources/resta.png")).getImage();
		this.img=imagen;
	}

	public void reactToCollision(Jugador jugador) {
		jugador.getPlatform().disminuirTamaņo();
		tablero.removerPoder(this);
	}
	
}
