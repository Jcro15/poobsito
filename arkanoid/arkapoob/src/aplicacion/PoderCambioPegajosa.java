package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;
public class PoderCambioPegajosa extends Poder {

	public PoderCambioPegajosa(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	
		Image imagen= new ImageIcon(getClass().getResource("/resources/pegajosa.png")).getImage();
		
		this.img=imagen;
	}

	@Override
	public void reactToCollision(Jugador jugador) {
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaPegajosa(p.getX(),p.getY(), tablero,p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}

}
