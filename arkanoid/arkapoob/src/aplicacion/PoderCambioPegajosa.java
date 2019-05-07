package aplicacion;

public class PoderCambioPegajosa extends Poder {

	public PoderCambioPegajosa(Arkapoob tablero, int xPosition, int yPosition) {
		super(tablero, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reactToCollision(Jugador jugador) {
		Plataforma p=jugador.getPlatform();
		jugador.setPlataforma(new PlataformaPegajosa(p.getX(),p.getY(), tablero,p.getHeight(),p.getWidth()));
		tablero.removerPoder(this);
	}

}
