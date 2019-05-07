package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderCambioEspecial extends Poder {
	public PoderCambioEspecial(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		Image imagen= new ImageIcon(getClass().getResource("/resources/especial.png")).getImage();
		
		this.img=imagen;
	}

	@Override
	public void reactToCollision(Jugador jugador) {
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaEspecial(p.getX(),p.getY(), tablero,p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}

}
