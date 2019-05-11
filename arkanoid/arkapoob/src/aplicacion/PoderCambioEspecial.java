package aplicacion;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PoderCambioEspecial extends Poder {
	public PoderCambioEspecial( int xPosition, int yPosition) {
		super(xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		
		
	}

	@Override
	public void reactToCollision(Jugador jugador) {
		Arkapoob tablero= Arkapoob.demeTablero();
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaEspecial(p.getX(),p.getY(), p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}
	
	public Image getImage(){
		Image img = new ImageIcon(getClass().getResource("/resources/especial.png")).getImage();
		return img;
	}

}
