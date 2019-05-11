package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;
public class PoderCambioPegajosa extends Poder {

	public PoderCambioPegajosa( int xPosition, int yPosition) {
		super( xPosition, yPosition);
		// TODO Auto-generated constructor stub
	
	
	}

	@Override
	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaPegajosa(p.getX(),p.getY(), p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/pegajosa.png")).getImage();
		return img;
	}

}
